package com.yk.lesson2HomeWork.task4Validation;

import java.math.BigDecimal;

public interface TransactionValidator {
    boolean validate(BigDecimal amount);
}
