package com.ejemplo;
import java.util.Vector;

/**
 * Implementación de un Stack utilizando Vector.
 * Esta clase proporciona una implementación thread-safe de un Stack
 * utilizando la estructura de datos Vector.
 *
 * @param <E> El tipo de elementos que contendrá el Stack
 */
public class StackVector<E> implements Stack<E> {
    protected Vector<E> data;

    /**
     * Constructor que inicializa un Stack vacío.
     */
    public StackVector() {
        data = new Vector<E>();
    }

    /**
     * Agrega un elemento al tope del Stack.
     * @param item El elemento a agregar
     */
    public void push(E item) {
        data.add(item);
    }

    /**
     * Elimina y devuelve el elemento en el tope del Stack.
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    public E pop() {
        return data.remove(size() - 1);
    }

    /**
     * Devuelve el elemento en el tope del Stack sin eliminarlo.
     * @return El elemento en el tope del Stack
     * @throws IndexOutOfBoundsException si el Stack está vacío
     */
    public E peek() {
        return data.get(size() - 1);
    }

    /**
     * Devuelve el número de elementos en el Stack.
     * @return La cantidad de elementos en el Stack
     */
    public int size() {
        return data.size();
    }

    /**
     * Verifica si el Stack está vacío.
     * @return true si el Stack está vacío, false en caso contrario
     */
    public boolean empty() {
        return size() == 0;
    }
}
