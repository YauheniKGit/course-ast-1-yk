package com.yk.lesson2HomeWork;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.CreditAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.DebitAccount;
import com.yk.lesson2HomeWork.task2InterfForTransFees.SavingsAccount;
import com.yk.lesson2HomeWork.task3PolymorTransProc.TransactionProcessor;

import java.util.List;

public class MainRunnerDemo {
    public static void main(String[] args) {

        List<BankAccount> bankAccounts = List.of(
                new DebitAccount(12345678, 500, "Jack"),
                new CreditAccount(1234579, 100, "Tom"),
                new SavingsAccount(1234580, 3500, "Sam")
        );
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        transactionProcessor.processTransaction(bankAccounts, 100);
        transactionProcessor.processTransaction(bankAccounts, 20);
        transactionProcessor.processTransaction(bankAccounts, 4500);
        transactionProcessor.processTransaction(bankAccounts, 7);

    }
}
