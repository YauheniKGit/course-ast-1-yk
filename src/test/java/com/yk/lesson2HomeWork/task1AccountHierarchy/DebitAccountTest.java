package com.yk.lesson2HomeWork.task1AccountHierarchy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DebitAccountTest {

    DebitAccount debitAccount;

    @BeforeEach
    void setUp() {
        debitAccount = new DebitAccount(1234567, new BigDecimal("1000"), "Jack");
    }

    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        debitAccount.deposit(new BigDecimal("500"));
        assertEquals(new BigDecimal("1500"), debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusNineHundredShouldEqualHundred() {
        debitAccount.withdraw(new BigDecimal("900"));
        assertEquals(new BigDecimal("100"), debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandOneHundredShouldEqualThousand() {
        debitAccount.withdraw(new BigDecimal("1100"));
        assertEquals(new BigDecimal("1000"), debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandShouldEqualZero() {
        debitAccount.withdraw(new BigDecimal("1000"));
        assertEquals(new BigDecimal("0"), debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusElevenThousandShouldEqualThousand() {
        debitAccount.withdraw(new BigDecimal("11000"));
        assertEquals(new BigDecimal("1000"), debitAccount.getBalance());
    }

    @Test
    void validateAmountMoreThanTenThousandShouldEqualFalse() {
        assertFalse(debitAccount.validate(new BigDecimal("11000")));
    }
}