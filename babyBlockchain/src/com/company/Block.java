package com.company;

public class Block {
    String blockID;
    String prevHash;
    Transaction[] setOfTransactions;

    public static Block createBlock(String prevHash, Transaction[] transactions) {
        Block block = new Block();
        block.blockID = String.valueOf(Math.random() * 10000);
        block.prevHash = prevHash;
        block.setOfTransactions = transactions;
        return block;
    }
}
