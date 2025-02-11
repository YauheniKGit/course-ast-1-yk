package com.yk.lesson2HomeWork.task1AccountHierarchy;

import com.yk.lesson2HomeWork.task2InterfForTransFees.TransactionFee;
import com.yk.lesson2HomeWork.task4Validation.TransactionValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditAccount extends BankAccount implements TransactionFee, TransactionValidator {

    private static final double CREDIT_LIMIT = -5000;
    private static final double FEE = 1;
    private static final double TRANSACTION_LIMIT = 5000;
    private static final double MAX_PERCENTAGE = 100;

    public CreditAccount(long accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (validate(amount) &&
                (getBalance().subtract(sumAmountAndFee(amount)).compareTo(BigDecimal.valueOf(CREDIT_LIMIT)) >= 0)) {
            applyFee(amount);
            setBalance(getBalance().subtract(amount));
        }
    }

    @Override
    public void applyFee(BigDecimal amount) {
        setBalance(getBalance().subtract(calculateFee(amount)));
    }

    @Override
    public boolean validate(BigDecimal amount) {
        return !(amount.compareTo(BigDecimal.valueOf(TRANSACTION_LIMIT)) > 0);
    }

    private BigDecimal calculateFee(BigDecimal amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(String.valueOf(amount));
        BigDecimal divideByPercentage = bigDecimalAmount.divide(BigDecimal.valueOf(MAX_PERCENTAGE), 4, RoundingMode.HALF_UP);
        return divideByPercentage.multiply(BigDecimal.valueOf(FEE));
    }

    private BigDecimal sumAmountAndFee(BigDecimal amount) {
        return amount.add(calculateFee(amount));
    }
}
