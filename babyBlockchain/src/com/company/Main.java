package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        KeyPair keyPair = KeyPair.genKeyPair();
        KeyPair.printKeyPair(keyPair);
        Signature signature = new Signature();
        System.out.println("Введите сообщение:");
        String message = s.nextLine();// в сообщении должно быть столько же или больше символов чем в закрытом ключе
        signature.value = Signature.signData(keyPair.pkCheck, message);
        Signature.printSignature(signature);
        Signature.verifySignature(signature.value, keyPair.publicKey, message);
        Signature.verifySignature("0", keyPair.publicKey, message);//всегда false
    }
}
