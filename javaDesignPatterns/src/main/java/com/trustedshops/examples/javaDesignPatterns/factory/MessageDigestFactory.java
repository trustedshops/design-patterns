package com.trustedshops.examples.javaDesignPatterns.factory;

import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;

public interface MessageDigestFactory {
    MessageDigest getMessageDigest();
}
