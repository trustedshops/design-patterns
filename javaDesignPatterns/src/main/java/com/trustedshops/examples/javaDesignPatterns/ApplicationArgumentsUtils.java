package com.trustedshops.examples.javaDesignPatterns;

import org.springframework.boot.ApplicationArguments;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ApplicationArgumentsUtils {
    private ApplicationArgumentsUtils() {
    }

    public static Map<String,Collection<String>> toOptionMap(ApplicationArguments args) {
        Map<String, Collection<String>> options = new HashMap<>();
        for(String name: args.getOptionNames()) {
            options.put(name, args.getOptionValues(name));
        }
        return options;
    }

}
