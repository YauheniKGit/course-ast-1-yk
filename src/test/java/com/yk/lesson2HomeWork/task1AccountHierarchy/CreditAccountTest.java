package com.yk.lesson2HomeWork.task1AccountHierarchy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    CreditAccount creditAccount;
    CreditAccount creditAccountWithLowBalance;

    @BeforeEach
    void setUp() {
        creditAccount = new CreditAccount(1234567, new BigDecimal("1000"), "Jack");
        creditAccountWithLowBalance = new CreditAccount(1234568, new BigDecimal("40"), "Sam");
    }

    @Test
    void depositThousandPlusFiveHundredShouldEqualThousandFiveHundred() {
        creditAccount.deposit(new BigDecimal("500"));
        assertEquals(new BigDecimal("1500"), creditAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusHundredShouldEqualEightHundredNinetyNine() {
        creditAccount.withdraw(new BigDecimal("100"));
        assertEquals(new BigDecimal("899.00000"), creditAccount.getBalance());
    }

    @Test
    void withdrawThousandMinusSixThousandShouldEqualThousand() {
        creditAccount.withdraw(new BigDecimal("6000"));
        assertEquals(new BigDecimal("1000"), creditAccount.getBalance());
    }

    @Test
    void withdrawFortyMinusFiveThousandShouldEqualForty() {
        creditAccountWithLowBalance.withdraw(new BigDecimal("5000"));
        assertEquals(new BigDecimal("40"), creditAccountWithLowBalance.getBalance());
    }

    @Test
    void withdrawFortyMinusThousandShouldMinusNineHundredSeventy() {
        creditAccountWithLowBalance.withdraw(new BigDecimal("1000"));
        assertEquals(new BigDecimal("-970.00000"), creditAccountWithLowBalance.getBalance());
    }

    @Test
    void applyFeeForThousandMinusHundredShouldEqualNineHundredNinetyNine() {
        creditAccount.applyFee(new BigDecimal("100"));
        assertEquals(new BigDecimal("999.00000"), creditAccount.getBalance());
    }

    @Test
    void validateAmountMoreThanFiveThousandOneShouldEqualFalse() {
        assertFalse(creditAccount.validate(new BigDecimal("5001")));
    }
}