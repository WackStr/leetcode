package com.wackstr.leetcode;

/*
2025-10-26
 */
public class Bank_2043 {
    private long[] balance;
    public Bank_2043(long[] balance){
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(isValidAccount(account1) && isValidAccount(account2)
        && balance[account1 - 1] >= money){
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(isValidAccount(account)){
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(isValidAccount(account) && balance[account - 1] >= money){
            balance[account - 1] -= money;
            return true;
        }
        return false;
    }

    private boolean isValidAccount(int account){
        return (account - 1) < balance.length;
    }
}
