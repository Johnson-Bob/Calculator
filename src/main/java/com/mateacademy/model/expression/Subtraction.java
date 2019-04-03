package com.mateacademy.model.expression;

import static com.mateacademy.model.expression.MathOperator.Prioritise.LOW;

public class Subtraction extends MathOperator {

    public Subtraction() {
        setPrioritise(LOW);
    }

    @Override
    public float calculate(float firstArgument, float secondArgument) {
        return firstArgument - secondArgument;
    }
}
