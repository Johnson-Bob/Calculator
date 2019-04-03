package com.mateacademy.model;

public class Operand<T> implements MathExpressionMember<T> {
    private T value;

    public Operand(T value) {
        this.value = value;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isBracket() {
        if (value != null && value instanceof Character) {
            return ((Character)value).equals('(') || ((Character)value).equals(')');
        }

        return false;
    }

    @Override
    public T getValue() {
        return value;
    }
}
