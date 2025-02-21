package com.ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Clase principal para evaluar expresiones matemáticas.
 * Este programa lee una expresión infija de un archivo, la convierte a notación postfija,
 * y evalúa el resultado usando operaciones de pila.
 */
public class Main {

    /**
     * Método principal que orquesta el proceso de evaluación de expresiones.
     * Lee la expresión del archivo, la convierte a postfija, evalúa e imprime el resultado.
     * 
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        try {
            String expression = readExpressionFromFile("com/ejemplo/datos.txt");
            String postfix = infixToPostfix(expression);
            int result = evaluatePostfix(postfix);
            System.out.println("El resultado de la expresión es: " + result);
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee una expresión matemática de un archivo.
     * 
     * @param filename El nombre del archivo que contiene la expresión
     * @return La expresión como un String
     * @throws IOException Si el archivo no puede leerse o no se encuentra
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
     * Convierte una expresión infija a notación postfija usando el algoritmo Shunting Yard.
     * 
     * @param expression La expresión infija a convertir
     * @return La expresión en notación postfija
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
     * Determina la precedencia de los operadores matemáticos.
     * 
     * @param ch El carácter del operador
     * @return El nivel de precedencia (número mayor significa mayor precedencia)
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
     * Evalúa una expresión postfija usando una pila.
     * 
     * @param expression La expresión postfija a evaluar
     * @return El resultado de la evaluación
     * @throws RuntimeException Si la expresión es inválida o incompleta
     */
    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Expresión postfix inválida: no hay suficientes operandos para el operador " + c);
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
            throw new RuntimeException("Expresión postfix inválida: pila vacía al final de la evaluación");
        }
        return stack.pop();
    }
}
