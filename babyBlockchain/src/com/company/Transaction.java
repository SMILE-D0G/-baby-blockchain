package com.company;

public class Transaction {
    String transactionID;
    Operation[] setOfOperations;
    String nonce;

    public static Transaction createTransaction(Operation[] ops, String nonce) {
        Transaction transaction = new Transaction();
        transaction.transactionID = String.valueOf(Math.random() * 10000);
        transaction.nonce = nonce;
        transaction.setOfOperations = ops;
        return transaction;
    }
}
