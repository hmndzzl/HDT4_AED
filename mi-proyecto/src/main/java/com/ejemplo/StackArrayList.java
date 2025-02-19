package com.ejemplo;
import java.util.ArrayList;

public class StackArrayList<E> implements Stack<E> {
    private ArrayList<E> data;

    /**
     * Constructor 
     */
    public StackArrayList() {
        data = new ArrayList<>();
    }

    /**
     * añade un elemento al stack
     * @param item es el elemento que se agregara
     */
    public void push(E item) {
        data.add(item);
    }

    /**
     * borra y devuelve el ultimo elemento añadido
     * @return lo eliminado
     * @throws IndexOutOfBoundsException si no hay elemento
     */
    public E pop() {
        return data.remove(size() - 1);
    }

    /**
     * Devuelve el ultimo elemento ingresado 
     * @return El ultimo elemento ingresado
     * @throws IndexOutOfBoundsException si esta vacío
     */
    public E peek() {
        return data.get(size() - 1);
    }

    /**
     * Devuelve el número de elementos 
     * @return Cantidad de elementos en el stack
     */
    public int size() {
        return data.size();
    }

    /**
     * Verifica si el stack esta vacio
     * @return false o true dependiendo si esta o no vacio el stack
     */
    public boolean empty() {
        return data.isEmpty();
    }
}
