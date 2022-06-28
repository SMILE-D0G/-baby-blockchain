package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        /*
        KeyPair keyPair = KeyPair.genKeyPair();
        KeyPair.printKeyPair(keyPair);
        Signature signature = new Signature();
        System.out.println("Введите сообщение:");
        String message = s.nextLine();// в сообщении должно быть столько же или больше символов чем в закрытом ключе
        signature.value = Signature.signData(keyPair.pkCheck, message);
        Signature.printSignature(signature);
        Signature.verifySignature(signature.value, keyPair.publicKey, message);
        */
        Account acc1 = Account.getAccount();
        acc1.addKeyPairToWallet();
        acc1.updateBalance(100);
        Account acc2 = Account.getAccount();
        acc1.createPaymentOp(acc2, 50, acc2.accountID);
        System.out.println(acc1.accountID + "'s current balance: " + acc1.getBalance() + "\n");
        acc1.printBalance();
        System.out.println("Введите сообщение:");
        String message = s.nextLine();// в сообщении должно быть столько же или больше символов чем в закрытом ключе
        acc1.signature = Signature.signData(acc1.wallet.pkCheck, message);
        System.out.println(acc1.accountID+"'s signature: "+acc1.signature);

    }
}
