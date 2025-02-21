package com.ejemplo;

/**
 * Interfaz que define las operaciones básicas de una lista.
 * 
 * @param <T> El tipo de elementos que contendrá la lista
 */
public interface Lista<T> {
    /**
     * Agrega un elemento al inicio de la lista.
     * @param elemento El elemento a agregar
     */
    void agregarInicio(T elemento);

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * @return El elemento eliminado
     */
    T eliminarInicio();

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     */
    boolean estaVacia();
}
