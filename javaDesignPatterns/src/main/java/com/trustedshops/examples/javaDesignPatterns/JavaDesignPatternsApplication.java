package com.trustedshops.examples.javaDesignPatterns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class JavaDesignPatternsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaDesignPatternsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.printf("\nJavaDesignPatternsApplication\n\n");
		System.out.printf("example usage:  javaDesignPatterns.jar command --foo=bar\n\n", args.getNonOptionArgs());
		System.out.printf("args: %s\n", args.getNonOptionArgs());
		System.out.printf("options: %s\n", args.getOptionNames());
	}
}
