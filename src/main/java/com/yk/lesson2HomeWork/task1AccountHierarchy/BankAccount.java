package com.yk.lesson2HomeWork.task1AccountHierarchy;

import java.math.BigDecimal;

public abstract class BankAccount {

    private final long accountNumber;
    private BigDecimal balance;
    private final String accountHolder;

    public BankAccount(long accountNumber, BigDecimal balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    public abstract void withdraw(BigDecimal amount);

    public void deposit(BigDecimal amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(String.valueOf(amount));
        BigDecimal bigDecimalBalance = new BigDecimal(String.valueOf(balance));
        balance = bigDecimalBalance.add(bigDecimalAmount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
