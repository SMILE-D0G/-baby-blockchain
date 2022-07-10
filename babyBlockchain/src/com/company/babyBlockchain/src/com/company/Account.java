package com.company;

public class Account {
    public String accountID;
    public KeyPair wallet;
    public int balance;

    public String signature;

    public static Account getAccount() {
        Account account = new Account();
        account.balance = 0;
        account.wallet = KeyPair.genKeyPair();
        account.accountID = String.valueOf(account.wallet.publicKey);
        System.out.println("Account ID: " + account.accountID);
        System.out.println("Account balance: " + account.balance + "\n");
        return account;
    }

    public void addKeyPairToWallet() {
        System.out.print("New " + this.accountID + "'s ID: ");
        this.wallet = KeyPair.genKeyPair();
        this.accountID = String.valueOf(this.wallet.publicKey);
        System.out.println(this.accountID + "\n");
    }

    public void updateBalance(int income) {
        this.balance += income;
        System.out.println("New " + this.accountID + "'s balance: " + this.balance + "\n");
    }

    public Operation createPaymentOp(Account account, int outcome, String idCheck) {
        Operation op = Operation.createOperation(this.accountID, account.accountID, outcome, this.signature);
        return op;
//        if (account.accountID == idCheck) {
//            if (this.balance >= outcome) {
//                this.balance -= outcome;
//                account.balance += outcome;
//                System.out.println(this.accountID + " sent " + outcome + " to " + account.accountID + "\n" +
//                        "New " + this.accountID + "'s balance: " + this.balance + "\n" +
//                        "New " + account.accountID + "'s balance: " + account.balance + "\n");
//            }
//        }
    }

    public int getBalance() {
        return this.balance;
    }

    public void printBalance() {
        System.out.println(this.accountID + "'s balance: " + this.balance + "\n");
    }


}
