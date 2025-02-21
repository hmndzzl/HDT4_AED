package com.ejemplo;

/**
 * Interface for a Postfix Calculator.
 * Provides methods to evaluate postfix expressions and perform operations.
 */
public interface Interfaz {
    /**
     * Evalúa una expresión en notación postfix y devuelve el resultado.
     * @param operacion La expresión en notación postfix a evaluar.
     * @return El resultado de la operación.
     */
    int evaluar(String operacion);

    /**
     * Realiza una operación matemática entre dos operandos dados un operador.
     * @param operandoA El primer operando.
     * @param operandoB El segundo operando.
     * @param operador El operador que se aplicará a los operandos.
     * @return El resultado de la operación.
     * @throws ArithmeticException Si se intenta dividir entre cero.
     * @throws IllegalArgumentException Si el operador no es válido.
     */
    int operar(int operandoA, int operandoB, String operador);
}
