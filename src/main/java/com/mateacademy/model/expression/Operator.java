package com.mateacademy.model.expression;

import com.mateacademy.model.MathExpressionMember;

public interface Operator extends MathExpressionMember<Character> {
    float calculate(float firstArgument, float secondArgument);
}
