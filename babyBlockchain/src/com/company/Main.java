package com.company;

public class Main {

    public static void main(String[] args) {
        KeyPair keyPair = KeyPair.genKeyPair();
        KeyPair.printKeyPair(keyPair);
    }
}
