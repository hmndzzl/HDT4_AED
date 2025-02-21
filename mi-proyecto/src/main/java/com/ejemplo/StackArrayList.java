package com.ejemplo;
import java.util.ArrayList;

/**
 * Implementación de un Stack utilizando ArrayList.
 * Esta clase proporciona una implementación eficiente de un Stack
 * utilizando la estructura de datos ArrayList.
 *
 * @param <E> El tipo de elementos que contendrá el Stack
 */
public class StackArrayList<E> implements Stack<E> {
    private ArrayList<E> data;

    /**
     * Constructor que inicializa un Stack vacío.
     */
    public StackArrayList() {
        data = new ArrayList<>();
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
        return data.isEmpty();
    }
}
