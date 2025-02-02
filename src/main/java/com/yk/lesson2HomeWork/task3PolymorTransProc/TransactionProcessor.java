package com.yk.lesson2HomeWork.task3PolymorTransProc;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessor {
    public void processTransaction(List<BankAccount> accounts, BigDecimal amount) {
        for (BankAccount account : accounts) {
            account.withdraw(amount);
        }
    }
}
