package com.yk.lesson2HomeWork.task3PolymorTransProc;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.CreditAccount;
import com.yk.lesson2HomeWork.task1AccountHierarchy.DebitAccount;
import com.yk.lesson2HomeWork.task2InterfForTransFees.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

    TransactionProcessor transactionProcessor;

    List<BankAccount> bankAccounts = List.of(
            new DebitAccount(12345678, new BigDecimal("100"), "Jack"),
            new CreditAccount(1234579, new BigDecimal("100"), "Tom"),
            new SavingsAccount(1234580, new BigDecimal("100"), "Sam")
    );

    @BeforeEach
    void setUp() {
        transactionProcessor = new TransactionProcessor();
    }

    @Test
    void processTransactionWithdrawDebitAccountHundredMinusHundredShouldEqualZero() {
        helper(new BigDecimal("100"));
        BankAccount debitAccount = bankAccounts.get(0);
        assertEquals(new BigDecimal("0"), debitAccount.getBalance());
    }

    @Test
    void processTransactionWithdrawCreditAccountHundredMinusThousandShouldMinusNineHundredTen() {
        helper(new BigDecimal("1000"));
        BankAccount creditAccount = bankAccounts.get(1);
        assertEquals(new BigDecimal("-910.00000"), creditAccount.getBalance());
    }

    @Test
    void processTransactionWithdrawSavingAccountHundredMinusHundredShouldEqualZero() {
        helper(new BigDecimal("100"));
        BankAccount savingAccount = bankAccounts.get(2);
        assertEquals(new BigDecimal("0"), savingAccount.getBalance());
    }

    void helper(BigDecimal amount) {
        transactionProcessor.processTransaction(bankAccounts, amount);
    }
}