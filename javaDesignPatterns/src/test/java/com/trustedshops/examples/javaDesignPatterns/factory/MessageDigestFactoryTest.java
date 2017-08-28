package com.trustedshops.examples.javaDesignPatterns.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.security.MessageDigest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigestFactoryTest {

    @Autowired
    private MessageDigestFactory messageDigestFactory;

    @Test
    public void getMessageDigest() {
        MessageDigest digest = messageDigestFactory.getMessageDigest();
        assertEquals("SHA-256", digest.getAlgorithm());
    }
}
