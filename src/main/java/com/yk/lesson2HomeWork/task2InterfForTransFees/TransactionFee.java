package com.yk.lesson2HomeWork.task2InterfForTransFees;

import java.math.BigDecimal;

public interface TransactionFee {
    void applyFee(BigDecimal amount);
}
