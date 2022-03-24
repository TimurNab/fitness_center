package com.timnab.fintess_center;

public interface Calculator<T extends Number> {

    double calculateFees(T clubID);

}
