package com.yk.lesson2HomeWork.task1AccountHierarchy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    CreditAccount creditAccount = new CreditAccount(1234567, 1000, "Jack");
    CreditAccount creditAccountWithLowBalance = new CreditAccount(1234568, 40, "Sam");

    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        creditAccount.deposit(500);
        assertEquals(1500, creditAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusHundredShouldEqualEightHundredNinetyNine() {
        creditAccount.withdraw(100);
        assertEquals(899, creditAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusSixThousandShouldEqualThousand() {
        creditAccount.withdraw(6000);
        assertEquals(1000, creditAccount.getBalance());
    }

    @Test
    void withdrawFortyMinusFiveThousandShouldEqualForty() {
        creditAccountWithLowBalance.withdraw(5000);
        assertEquals(40, creditAccountWithLowBalance.getBalance());
    }

    @Test
    void withdrawFortyMinusThousandShouldMinusNineHundredSeventy() {
        creditAccountWithLowBalance.withdraw(1000);
        assertEquals(-970.0, creditAccountWithLowBalance.getBalance());
    }

    @Test
    void applyFeeForThousandMinusHundredShouldEqualNineHundredNinetyNine() {
         creditAccount.applyFee(100);
         assertEquals(999, creditAccount.getBalance());
    }

    @Test
    void validateAmountMoreThanFiveThousandOneShouldEqualFalse() {
        assertFalse(creditAccount.validate(5001));
    }
}