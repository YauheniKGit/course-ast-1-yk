package com.yk.lesson2HomeWork.task2InterfForTransFees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(1234567, new BigDecimal("1000"), "Jack");
    }

    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        savingsAccount.deposit(new BigDecimal("500"));
        assertEquals(new BigDecimal("1500"), savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusNineHundredShouldEqualHundred() {
        savingsAccount.withdraw(new BigDecimal("900"));
        assertEquals(new BigDecimal("100"), savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandOneHundredShouldEqualThousand() {
        savingsAccount.withdraw(new BigDecimal("1100"));
        assertEquals(new BigDecimal("1000"), savingsAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandShouldEqualZero() {
        savingsAccount.withdraw(new BigDecimal("1000"));
        assertEquals(new BigDecimal("0"), savingsAccount.getBalance());
    }

    @Test
    void applyInterestMonthlyForBalanceThousandWithAnnualRateElevenShouldEqualThousandNinePointSixteen() {
        savingsAccount.applyInterest();
        assertEquals(new BigDecimal("1009.1667"), savingsAccount.getBalance());
    }
}