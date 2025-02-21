package com.ejemplo;

/**
 * Clase Factory que implementa el patrón Factory Method para crear instancias de StackList.
 * Permite crear diferentes tipos de implementaciones de lista para StackList.
 */
public class FactoryList {
    /**
     * Crea y devuelve una instancia de StackList según el tipo de lista especificado.
     * @param tipo El tipo de lista a utilizar (1: Simplemente encadenada, 2: Doblemente enlazada).
     * @return Una instancia de StackList con el tipo de lista especificado.
     * @throws IllegalArgumentException Si el tipo no es válido.
     */
    public static Stack<Integer> getStackList(int tipo) {
        if (tipo == 1) {
            return new SingleLinked();
        } else if (tipo == 2) {
            return new DoubleLinked();
        } else {
            return null;
        }
    }
}
