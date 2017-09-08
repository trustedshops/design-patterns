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
public class JavaDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDesignPatternsApplication.class, args);
	}

}
