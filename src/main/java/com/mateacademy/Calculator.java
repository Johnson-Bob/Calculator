package com.mateacademy;

import com.mateacademy.model.MathExpressionMember;
import com.mateacademy.model.Operand;
import com.mateacademy.model.expression.Operator;

import java.util.List;
import java.util.Stack;

/**
 * Calculate math expression
 */
public class Calculator {
    private List<MathExpressionMember> postfixExpression;
    private Stack<MathExpressionMember<Float>> operandStack = new Stack<>();

    public float calculateExpression(String input) {
        String expression = input.trim();
        postfixExpression = new ExpresionParser().getExpressions(expression);
        return calculate();
    }

    private float calculate() {
        operandStack.clear();
        for (int i = 0; i < postfixExpression.size(); i++) {
            MathExpressionMember member = postfixExpression.get(i);
            if (!member.isOperator()) {
                operandStack.push(member);
            } else {
                float secondArgument = operandStack.pop().getValue();
                float firstArgument = operandStack.pop().getValue();
                float resultOperation = ((Operator)member).calculate(firstArgument, secondArgument);
                Operand<Float> resultOperand = new Operand<>(resultOperation);
                operandStack.push(resultOperand);
            }
        }

        return operandStack.pop().getValue();
    }
}
