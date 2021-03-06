package com.company;

public class Operation {
    public String sender;
    public String receiver;
    public int amount;
    public String signature;

    public static Operation createOperation(String sender, String receiver, int amount, String signature) {
        Operation op = new Operation();
        op.amount = amount;
        op.receiver = receiver;
        op.sender = sender;
        op.signature = signature;
        return op;
    }

    public static boolean verifyOperation(int balance, String signature, Operation op) {
        boolean isTrue = false;
        if ((signature.equals(op.signature)) && (balance > op.amount))
            isTrue = true;
        return isTrue;
    }
}
