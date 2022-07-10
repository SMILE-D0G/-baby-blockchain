package com.company;

import java.math.BigInteger;
import java.util.Random;

public class KeyPair {
    private BigInteger privateKey;
    public BigInteger pkCheck;//для проверки подписи
    public int publicKey;

    public static KeyPair genKeyPair() {
        KeyPair keyPair = new KeyPair();
        keyPair.privateKey = new BigInteger(64, new Random());
        keyPair.pkCheck = keyPair.privateKey;
        keyPair.publicKey = keyPair.privateKey.hashCode();
        return keyPair;
    }

    public static void printKeyPair(KeyPair keyPair) {
        System.out.println("Приватный ключ: " + keyPair.privateKey.toString() + "\n" + "Публичный ключ: " + keyPair.publicKey);
    }
}
