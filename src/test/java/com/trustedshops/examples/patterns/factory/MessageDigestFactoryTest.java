package com.trustedshops.examples.patterns.factory;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageDigestFactoryTest {

    private MessageDigestFactory messageDigestFactory = new MessageDigestFactoryImpl("SHA-256");

    @Test
    public void getMessageDigest() {
        MessageDigest digest = messageDigestFactory.getMessageDigest();
        assertEquals("SHA-256", digest.getAlgorithm());
    }
}
