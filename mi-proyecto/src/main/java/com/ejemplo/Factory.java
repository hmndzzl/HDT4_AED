package com.ejemplo;

/**
 * Clase Factory que implementa el patrón Factory Method para crear instancias de Stack.
 * Permite crear diferentes tipos de implementaciones de Stack.
 */
public class Factory {
    /**
     * Crea y devuelve una instancia de Stack según el tipo especificado.
     * @param tipo El tipo de Stack a crear (1: ArrayList, 2: Vector, 3: Lista enlazada).
     * @return Una instancia de Stack del tipo especificado.
     * @throws IllegalArgumentException Si el tipo no es válido.
     */
    public static Stack<Integer> getStack(int tipo) {
        if (tipo == 1) {
            return new StackArrayList<>();
        } else if (tipo == 2) {
            return new StackVector<>();
        } else if (tipo == 3) {
            return new StackList<>();
        } else {
            return null;
        }
    }
}
