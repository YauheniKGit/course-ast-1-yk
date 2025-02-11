package com.yk.lesson2HomeWork.task2InterfForTransFees;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount extends BankAccount implements InterestBearing {

    private static final double ANNUAL_INTEREST_RATE = 11;
    private static final byte NUMBER_OF_MONTH_IN_YEAR = 12;
    private static final byte MAX_PERCENTAGE = 100;

    public SavingsAccount(long accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (getBalance().compareTo(amount) >= 0) {
            setBalance(getBalance().subtract(amount));
        }
    }

    @Override
    public void applyInterest() {
        double monthlyInterestRate = ANNUAL_INTEREST_RATE / NUMBER_OF_MONTH_IN_YEAR;
        BigDecimal divideByMaxPercentResult = getBalance().divide(BigDecimal.valueOf(MAX_PERCENTAGE), 4, RoundingMode.HALF_UP);
        BigDecimal monthlyInterest = divideByMaxPercentResult.multiply(BigDecimal.valueOf(monthlyInterestRate));
        setBalance(getBalance().add(monthlyInterest.setScale(4, RoundingMode.HALF_UP)));
    }
}
