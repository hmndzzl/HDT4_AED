package com.ejemplo;

/**
 * Implementación de una lista simplemente encadenada que también funciona como Stack.
 * Esta clase proporciona una implementación eficiente de una lista enlazada simple
 * con operaciones de Stack.
 */
public class SingleLinked implements Stack<Integer> {
    private Nodo primero;
    private int size;

    /**
     * Clase interna para los nodos de la lista
     * @param dato El valor almacenado en el nodo
     * @param siguiente Referencia al siguiente nodo en la lista
     */
    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    /**
     * Constructor que inicializa una lista vacía.
     */
    public SingleLinked() {
        primero = null;
        size = 0;
    }

    /**
     * Agrega un elemento al tope del Stack.
     * @param item El elemento a agregar
     */
    @Override
    public void push(Integer item) {
        primero = new Nodo(item, primero);
        size++;
    }

    /**
     * Elimina y devuelve el elemento en el tope del Stack.
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    @Override
    public Integer pop() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        int item = primero.dato;
        primero = primero.siguiente;
        size--;
        return item;
    }

    /**
     * Devuelve el elemento en el tope del Stack sin eliminarlo.
     * @return El elemento en el tope del Stack
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    @Override
    public Integer peek() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        return primero.dato;
    }

    /**
     * Devuelve el número de elementos en el Stack.
     * @return La cantidad de elementos en el Stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica si el Stack está vacío.
     * @return true si el Stack está vacío, false en caso contrario
     */
    @Override
    public boolean empty() {
        return size == 0;
    }
}
