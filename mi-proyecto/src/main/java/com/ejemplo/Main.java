package com.ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Main class for evaluating mathematical expressions.
 * This program reads an infix expression from a file, converts it to postfix notation,
 * and evaluates the result using stack operations.
 */
public class Main {

    /**
     * Main method that orchestrates the expression evaluation process.
     * Reads expression from file, converts to postfix, evaluates, and prints result.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            String expression = readExpressionFromFile("com/ejemplo/datos.txt");
            String postfix = infixToPostfix(expression);
            int result = evaluatePostfix(postfix);
            System.out.println("The result of the expression is: " + result);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Reads a mathematical expression from a file.
     * 
     * @param filename The name of the file containing the expression
     * @return The expression as a String
     * @throws IOException If the file cannot be read or is not found
     */
    private static String readExpressionFromFile(String filename) throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String expression = reader.readLine();
        reader.close();
        return expression;
    }

    /**
     * Converts an infix expression to postfix notation using the Shunting Yard algorithm.
     * 
     * @param expression The infix expression to convert
     * @return The expression in postfix notation
     */
    private static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    /**
     * Determines the precedence of mathematical operators.
     * 
     * @param ch The operator character
     * @return The precedence level (higher number means higher precedence)
     */
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * Evaluates a postfix expression using a stack.
     * 
     * @param expression The postfix expression to evaluate
     * @return The result of the evaluation
     * @throws RuntimeException If the expression is invalid or incomplete
     */
    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid postfix expression: not enough operands for operator " + c);
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            throw new RuntimeException("Invalid postfix expression: empty stack at end of evaluation");
        }
        return stack.pop();
    }
}
