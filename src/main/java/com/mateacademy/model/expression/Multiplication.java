package com.mateacademy.model.expression;

import static com.mateacademy.model.expression.MathOperator.Prioritise.HIGH;

public class Multiplication extends MathOperator {
    public Multiplication() {
        setPrioritise(HIGH);
    }

    @Override
    public float calculate(float firstArgument, float secondArgument) {
        return firstArgument * secondArgument;
    }
}
