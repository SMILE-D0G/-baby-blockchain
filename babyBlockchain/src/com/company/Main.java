package com.company;

import java.security.NoSuchAlgorithmException;
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
        System.out.println(Signature.verifySignature(signature.value, keyPair.publicKey, message));
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
        System.out.println(acc1.accountID + "'s signature: " + acc1.signature);
        Operation op1 = Operation.createOperation(acc1.accountID, acc2.accountID, 1, acc1.signature);
        System.out.println(Operation.verifyOperation(acc1.balance, acc1.signature, op1));
        Operation op2 = Operation.createOperation(acc1.accountID, acc2.accountID, 3, acc1.signature);
        String nonce = "nonce";
        Operation[] ops = {op1, op2};
        Transaction tr1 = Transaction.createTransaction(ops, nonce);

        /*
        String message = s.nextLine();
        try {
            message = Hash.toSHA1(message);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Ошибка");
        }
        System.out.println(message);
        */
        Block block = Block.createBlock("000000000000000", new Transaction[]{tr1});
    }
}
