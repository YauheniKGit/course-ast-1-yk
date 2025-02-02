package com.yk.lesson2HomeWork.task3PolymorTransProc;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.CreditAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.DebitAccount;
import com.yk.lesson2HomeWork.task2InterfForTransFees.SavingsAccount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

    TransactionProcessor transactionProcessor = new TransactionProcessor();

    List<BankAccount> bankAccounts = List.of(
            new DebitAccount(12345678, 100, "Jack"),
            new CreditAccount(1234579, 100, "Tom"),
            new SavingsAccount(1234580, 100, "Sam")
    );

    @Test
    void processTransactionWithdrawDebitAccountHundredMinusHundredShouldEqualZero() {
        helper(100);
        BankAccount debitAccount = bankAccounts.get(0);
        assertEquals(0, debitAccount.getBalance());
    }

    @Test
    void processTransactionWithdrawCreditAccountHundredMinusThousandShouldMinusNineHundredTen() {
        helper(1000);
        BankAccount creditAccount = bankAccounts.get(1);
        assertEquals(-910, creditAccount.getBalance());
    }

    @Test
    void processTransactionWithdrawSavingAccountHundredMinusHundredShouldEqualZero() {
        helper(100);
        BankAccount savingAccount = bankAccounts.get(2);
        assertEquals(0, savingAccount.getBalance());
    }

    void helper(double amount){
        transactionProcessor.processTransaction(bankAccounts, amount);
    }
}