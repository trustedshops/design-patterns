package com.trustedshops.examples.javaDesignPatterns;

import com.trustedshops.examples.javaDesignPatterns.command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.*;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class JavaDesignPatternsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaDesignPatternsApplication.class, args);
	}

	@Value("${app.debug}")
	private boolean appDebug;

	@Autowired
	private CommandFactory commandFactory;

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> nonOptionArgs = args.getNonOptionArgs();
		if(nonOptionArgs.size() < 1) {
			printUsage();
			System.exit(1);
		}
		String command = nonOptionArgs.get(0);
		try {
			List<String> commandArgs = nonOptionArgs.subList(1, nonOptionArgs.size());
			Map<String, Collection<String>> commandOptions = ApplicationArgumentsUtils.toOptionMap(args);
			getCommandFactory().create(command).execute(commandArgs, commandOptions);
		} catch (Exception e) {
			printError(e);
			printUsage();
			System.exit(2);
		}
	}

	private void printError(Exception e) {
		System.out.printf("\nERROR: %s - %s\n", e.getClass().getSimpleName(), e.getMessage());
		if(appDebug) {
			e.printStackTrace();
		}
	}


	private void printUsage() {
		System.out.printf("\nJavaDesignPatternsApplication\n\n");
		System.out.printf("usage:  javaDesignPatterns.jar COMMAND [args] [options]\n\n");
	}
}
