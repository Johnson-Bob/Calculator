package com.mateacademy.model.expression;

import static com.mateacademy.model.expression.MathOperator.Prioritise.HIGH;

public class Division extends MathOperator {

    public Division() {
        setPrioritise(HIGH);
    }

    @Override
    public float calculate(float firstArgument, float secondArgument) {
        if (secondArgument == 0) {
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        return firstArgument / secondArgument;
    }
}
