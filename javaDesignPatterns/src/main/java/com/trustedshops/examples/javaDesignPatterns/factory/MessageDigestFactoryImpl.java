package com.trustedshops.examples.javaDesignPatterns.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MessageDigestFactoryImpl implements MessageDigestFactory{
    @Value("${digest.algorithm}")
    private String algorithm;

    @Override
    public MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
