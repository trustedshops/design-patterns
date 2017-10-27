package com.trustedshops.examples.javaDesignPatterns.factory;

import org.junit.Test;
import static org.junit.Assert.*;
import java.security.MessageDigest;

public class MessageDigestFactoryTest {

    private MessageDigestFactory messageDigestFactory = new MessageDigestFactoryImpl("SHA-256");

    @Test
    public void getMessageDigest() {
        MessageDigest digest = messageDigestFactory.getMessageDigest();
        assertEquals("SHA-256", digest.getAlgorithm());
    }
}
