package com.yk.lesson2HomeWork.task2InterfForTransFees;

import com.yk.lesson2HomeWork.task1AccountHierarchy.BankAccount;

public class SavingsAccount extends BankAccount implements InterestBearing {

    private final double annualInterestRate = 11;
    private final byte numberOfMonthInYear = 12;
    private final byte maximumPercentage = 100;

    public SavingsAccount(long accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public void applyInterest() {
        double monthlyInterestRate = annualInterestRate / numberOfMonthInYear;
        double monthlyInterest = getBalance() / maximumPercentage * monthlyInterestRate;
        setBalance(getBalance() + monthlyInterest);
    }

}
