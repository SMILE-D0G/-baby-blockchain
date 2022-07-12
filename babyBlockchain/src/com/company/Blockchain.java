package com.company;

public class Blockchain {
    String coinDatabase;
    Block[] blockHistory;
    Transaction[] txDatabase;
    int faucetCoins;

    public static void initBlockchain() {

    }

    public static void getTokenFromFaucet() {

    }

    public static Blockchain validateBlock(Block block, Blockchain bc) {
        boolean isTransationsNotInHistory = false;
        boolean isTransactionOperationsChecked = false;
        int test = 0;
        for (int i = 0; i < bc.txDatabase.length; i++) {
            for (int j = 0; j < block.setOfTransactions.length; j++) {
                if (!(bc.txDatabase[i].equals(block.setOfTransactions[j]))) test++;
            }
        }
        if (test == bc.txDatabase.length * block.setOfTransactions.length) isTransationsNotInHistory = true;
        test = 0;
        for (int i = 0; i < bc.txDatabase.length; i++) {
            for (int j = 0; j < bc.txDatabase[i].setOfOperations.length; j++) {
                if (Operation.verifyOperation(1000/*плохо реализовал метод проверки операций*/, bc.txDatabase[i].setOfOperations[j].signature, bc.txDatabase[i].setOfOperations[j]))
                    isTransactionOperationsChecked = true;
                else test++;
            }
        }
        if (test>0) isTransactionOperationsChecked = false;
        if ((block.prevHash.equals(bc.blockHistory[bc.blockHistory.length - 1])) &&
                (isTransationsNotInHistory) &&
                //(Проверка того что блок не содержит конфликтующих транзакций)&&
                (isTransactionOperationsChecked)) {
            Block[] newBlockHistory = new Block[bc.blockHistory.length + 1];
            for (int i = 0; i < bc.blockHistory.length; i++)
                newBlockHistory[i] = bc.blockHistory[i];
            newBlockHistory[bc.blockHistory.length] = block;
            bc.blockHistory = newBlockHistory;
        }
        return bc;
    }

    public static void getCoinDatabase() {

    }
}
