package com.ejemplo;

/**
 * Clase abstracta que implementa una lista genérica.
 * Proporciona una implementación base para operaciones comunes de listas.
 * 
 * @param <T> El tipo de elementos que contendrá la lista
 */
public abstract class ListaA<T> implements Lista<T> {
    protected int tamaño = 0;

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     */
    @Override
    public boolean estaVacia() {
        return tamaño == 0;
    }
}
