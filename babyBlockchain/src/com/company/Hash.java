package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String toSHA1(String message) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
        byte[] bytes = sha1.digest(message.getBytes(StandardCharsets.UTF_8));
        message = new String(bytes, StandardCharsets.UTF_8);
        return message;
    }
}
