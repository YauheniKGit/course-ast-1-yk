package com.yk.lesson2HomeWork.task1AccountHierarchy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DebitAccountTest {

    DebitAccount debitAccount = new DebitAccount(1234567, 1000, "Jack");
    
    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        debitAccount.deposit(500);
        assertEquals(1500, debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusNineHundredShouldEqualHundred() {
        debitAccount.withdraw(900);
        assertEquals(100, debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandOneHundredShouldEqualThousand() {
        debitAccount.withdraw(1100);
        assertEquals(1000, debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusThousandShouldEqualZero() {
        debitAccount.withdraw(1000);
        assertEquals(0, debitAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusElevenThousandShouldEqualThousand() {
        debitAccount.withdraw(11000);
        assertEquals(1000, debitAccount.getBalance());
    }

    @Test
    void validateAmountMoreThanTenThousandShouldEqualFalse() {
        assertFalse(debitAccount.validate(11000));
    }
}