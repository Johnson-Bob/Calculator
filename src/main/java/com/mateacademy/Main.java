package com.mateacademy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter math expression: ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            float result = new Calculator().calculateExpression(input);
            System.out.println("Result = " + result);
        }
    }
}
