package com.yk.lesson2HomeWork.task2InterfForTransFees;

import com.yk.lesson2HomeWork.task1AccountHierarchy.CreditAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    SavingsAccount savingsAccount = new SavingsAccount(1234567, 1000, "Jack");

    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        savingsAccount.deposit(500);
        assertEquals(1500, savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusNineHundredShouldEqualHundred() {
        savingsAccount.withdraw(900);
        assertEquals(100, savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandOneHundredShouldEqualThousand() {
        savingsAccount.withdraw(1100);
        assertEquals(1000, savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandShouldEqualZero() {
        savingsAccount.withdraw(1000);
        assertEquals(0, savingsAccount.getBalance());
    }

    @Test
    void applyInterestMonthlyForBalanceThousandWithAnnualRateElevenShouldEqualThousandNinePointSixteen() {
    savingsAccount.applyInterest();
    assertEquals(1009.1666666666666, savingsAccount.getBalance());
    }
}