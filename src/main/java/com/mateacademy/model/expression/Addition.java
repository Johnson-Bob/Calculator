package com.mateacademy.model.expression;

import static com.mateacademy.model.expression.MathOperator.Prioritise.LOW;

public class Addition extends MathOperator {

    public Addition() {
        setPrioritise(LOW);
    }

    @Override
    public float calculate(float firstArgument, float secondArgument) {
        return firstArgument + secondArgument;
    }
}
