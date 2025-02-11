package com.yk.lesson2HomeWork.task1AccountHierarchy;

import com.yk.lesson2HomeWork.task4Validation.TransactionValidator;

import java.math.BigDecimal;

public class DebitAccount extends BankAccount implements TransactionValidator {

    private static final double TRANSACTION_LIMIT = 10000;

    public DebitAccount(long accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (validate(amount) && getBalance().compareTo(amount) >= 0) {
            setBalance(getBalance().subtract(amount));
        }
    }

    @Override
    public boolean validate(BigDecimal amount) {
        return !(amount.compareTo(BigDecimal.valueOf(TRANSACTION_LIMIT)) > 0);
    }
}
