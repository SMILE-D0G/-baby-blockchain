package com.company;

import java.math.BigInteger;

public class Signature {
    public String value;
    private static int length = 0;

    public static String signData(BigInteger privateKey, String message) {
        String signature = "";
        int pKey = 0;
        StringBuilder sbPrivateKey = new StringBuilder(privateKey.toString());
        length = sbPrivateKey.length();
        StringBuilder sbMessage = new StringBuilder(message);
        StringBuilder sbSignature = new StringBuilder();
        for (int i = 0; i < sbMessage.length(); i++) {
            pKey = (sbPrivateKey.charAt(i % (sbPrivateKey.length())) + 1) % 10;
            sbSignature.append(sbMessage.charAt(i));
            sbSignature.append(pKey);
        }
        signature = sbSignature.toString();
        return signature;
    }

    public static boolean verifySignature(String signature, int publicKey, String message) {
        boolean isTrue = false;
        System.out.print("Verifying signature result: ");
        StringBuilder sbPrivateKey = new StringBuilder();
        StringBuilder sbSignature = new StringBuilder(signature);
        int pKey = 0;
        for (int i = 1; i < sbSignature.length(); i = i + 2) {
            pKey = (sbSignature.charAt(i) + 3) % 10;
            sbPrivateKey.append(pKey);
        }
        sbPrivateKey.delete(length, sbPrivateKey.length());
        BigInteger privateKey = new BigInteger(String.valueOf(sbPrivateKey));
        if (publicKey == privateKey.hashCode()) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    public static void printSignature(Signature signature) {
        System.out.println("Подпись: " + signature.value);
    }
}
