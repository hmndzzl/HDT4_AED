package com.ejemplo;

/**
 * Implementación de una lista doblemente enlazada que también funciona como Stack.
 * Esta clase proporciona una implementación eficiente de una lista doblemente enlazada
 * con operaciones de Stack.
 *
 * @param <T> El tipo de elementos que contendrá la lista/Stack
 */
public class DoubleLinked<T> extends ListaA<T> implements Stack<T> {
    /**
     * Clase interna para los nodos de la lista
     */
    private class Nodo {
        T dato;
        Nodo siguiente, anterior;

        /**
         * Constructor para crear un nuevo nodo
         * @param dato El valor a almacenar en el nodo
         */
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = this.anterior = null;
        }
    }

    private Nodo cabeza;

    /**
     * Agrega un elemento al tope del Stack.
     * @param elemento El elemento a agregar
     */
    @Override
    public void push(T elemento) {
        agregarInicio(elemento);
    }

    /**
     * Elimina y devuelve el elemento en el tope del Stack.
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    @Override
    public T pop() {
        return eliminarInicio();
    }

    /**
     * Devuelve el elemento en el tope del Stack sin eliminarlo.
     * @return El elemento en el tope del Stack
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    @Override
    public T peek() {
        if (estaVacia()) throw new IndexOutOfBoundsException("stack vacio");
        return cabeza.dato;
    }

    /**
     * Devuelve el número de elementos en el Stack.
     * @return La cantidad de elementos en el Stack
     */
    @Override
    public int size() {
        return tamaño;
    }

    /**
     * Verifica si el Stack está vacío.
     * @return true si el Stack está vacío, false en caso contrario
     */
    @Override
    public boolean empty() {
        return estaVacia();
    }

    /**
     * Agrega un elemento al inicio de la lista.
     * @param elemento El elemento a agregar
     */
    @Override
    public void agregarInicio(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (cabeza != null) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
        tamaño++;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * @return El elemento eliminado
     */
    @Override
    public T eliminarInicio() {
        if (estaVacia()) return null;
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        tamaño--;
        return dato;
    }
}
