package com.mateacademy.model;

public interface MathExpressionMember<T> {
    boolean isOperator();
    boolean isBracket();
    T getValue();
}
