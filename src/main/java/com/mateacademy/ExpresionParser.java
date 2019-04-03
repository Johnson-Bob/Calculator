package com.mateacademy;

import com.mateacademy.model.MathExpressionMember;
import com.mateacademy.model.Operand;
import com.mateacademy.model.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create MathExpressionMember collection in postfix mode
 */
public class ExpresionParser {
    private static final String regex = "\\d+\\.{0,1}\\d*|[*+-/]{1}|[()]{1}";
    private List<MathExpressionMember> postfixExpression = new ArrayList<>();
    private Stack<MathExpressionMember<Character>> operationStack = new Stack<>();

    public List<MathExpressionMember> getExpressions(String mathExpresion) {
        clearCollections();
        Matcher matcher = Pattern.compile(regex).matcher(mathExpresion);
        while (matcher.find()) {
            handleMathExpressionMember(createExpression(matcher.group()));
        }

        while (!operationStack.empty()) {
            postfixExpression.add(operationStack.pop());
        }
        return postfixExpression;
    }

    private MathExpressionMember createExpression(String match) {
        MathExpressionMember member;
        switch (match) {
            case "+" :
                 member = new Addition();
                 break;
            case "-" :
                member = new Subtraction();
                break;
            case "*" :
                member = new Multiplication();
                break;
            case "/" :
                member = new Division();
                break;
            case "(":
            case ")":
                member = new Operand<Character>(match.charAt(0));
                break;
            default:
                member = new Operand<Float>(Float.parseFloat(match));
                break;
        }

        return member;
    }

    private void handleMathExpressionMember(MathExpressionMember member) {
        if (member.isOperator()) {
            handleOperator((MathOperator) member);
        } else {
            if(member.isBracket()) {
                handleBrackets(member);
            } else {
                postfixExpression.add(member);
            }
        }
    }

    private void handleOperator(MathOperator operator) {
        if (operationStack.empty()) {
            operationStack.push(operator);
        } else {
            while (!operationStack.empty()) {
                MathExpressionMember<Character> topMember = operationStack.pop();
                if (topMember.getValue().equals('(')) {
                    operationStack.push(topMember);
                    break;
                } else if (((MathOperator)topMember).compareTo(operator) < 0) {
                    operationStack.push(topMember);
                    break;
                } else {
                    postfixExpression.add(topMember);
                }
            }
            operationStack.push(operator);
        }
    }

    private void handleBrackets(MathExpressionMember<Character> bracket) {
        if (bracket.getValue().equals('(')) {
            operationStack.push(bracket);
        } else {
            while (!operationStack.empty()) {
                MathExpressionMember topMember = operationStack.pop();
                if (topMember.getValue().equals('(')) {
                    break;
                } else {
                    postfixExpression.add(topMember);
                }
            }
        }
    }

    private void clearCollections() {
        postfixExpression.clear();
        operationStack.clear();
    }
}
