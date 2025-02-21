package com.ejemplo;

/**
 * Implementación de un Stack utilizando una lista enlazada.
 * Esta clase proporciona una implementación eficiente de un Stack
 * utilizando una estructura de nodos enlazados.
 *
 * @param <E> El tipo de elementos que contendrá el Stack
 */
public class StackList<E> implements Stack<E> {
    private Nodo<E> ultimo;
    private int size;

    /**
     * Clase interna para los nodos de la lista
     */
    private static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;

        Nodo(E dato, Nodo<E> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    /**
     * Constructor que inicializa un Stack vacío.
     */
    public StackList() {
        ultimo = null;
        size = 0;
    }

    /**
     * Agrega un elemento al tope del Stack.
     * @param item El elemento a agregar
     */
    public void push(E item) {
        ultimo = new Nodo<>(item, ultimo);
        size++;
    }

    /**
     * Elimina y devuelve el elemento en el tope del Stack.
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    public E pop() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        E item = ultimo.dato;
        ultimo = ultimo.siguiente;
        size--;
        return item;
    }

    /**
     * Devuelve el elemento en el tope del Stack sin eliminarlo.
     * @return El elemento en el tope del Stack
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    public E peek() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        return ultimo.dato;
    }

    /**
     * Devuelve el número de elementos en el Stack.
     * @return La cantidad de elementos en el Stack
     */
    public int size() {
        return size;
    }

    /**
     * Verifica si el Stack está vacío.
     * @return true si el Stack está vacío, false en caso contrario
     */
    public boolean empty() {
        return ultimo == null;
    }
}
