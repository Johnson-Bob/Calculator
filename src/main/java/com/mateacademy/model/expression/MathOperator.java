package com.mateacademy.model.expression;

public abstract class MathOperator implements Operator, Comparable<MathOperator> {
    private Prioritise prioritise;

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public boolean isBracket() {
        return false;
    }

    @Override
    public Character getValue() {
        return new Character('0');
    }

    protected void setPrioritise(Prioritise prioritise) {
        this.prioritise = prioritise;
    }

    @Override
    public int compareTo(MathOperator o) {
        return this.prioritise.compareTo(o.prioritise);
    }

    public enum Prioritise {
        LOW, HIGH
    }
}
