package com.trustedshops.examples.javaDesignPatterns.factory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactoryImpl implements MessageDigestFactory {
    private final String algorithm;

    public MessageDigestFactoryImpl(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
