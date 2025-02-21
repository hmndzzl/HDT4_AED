package com.ejemplo;

//Esta clase se encargará de implementar y leer la lista simplemente encadenada.
public class SingleLinked {
    private Nodo primero;
    private int size;

    /**
     * Clase interna para los nodos de la lista
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
     * Constructor
     */
    public SingleLinked() {
        primero = null;
        size = 0;
    }

    /**
     * Agrega un elemento al inicio de la lista
     * @param item el elemento a agregar
     */
    public void agregarInicio(int item) {
        primero = new Nodo(item, primero);
        size++;
    }

    /**
     * Agrega un elemento al final de la lista
     * @param item lo que se agregara
     */
    public void agregarFinal(int item) {
        if (primero == null) {
            primero = new Nodo(item, null);
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo(item, null);
        }
        size++;
    }

    /**
     * Borra y devuelve el primer elemento de la lista
     * @return el elemento eliminado
     * @throws IndexOutOfBoundsException si no hay nada
     */
    public int pop() {
        if (empty()) throw new IndexOutOfBoundsException("lista vacía");
        int item = primero.dato;
        primero = primero.siguiente;
        size--;
        return item;
    }

    /**
     * Devuelve el ultimo dato ingresado
     * @return lo ultimo de la lista
     * @throws IndexOutOfBoundsException si la lista esta vacía
     */
    public int peek() {
        if (empty()) throw new IndexOutOfBoundsException("lista vacía");
        return primero.dato;
    }

    /**
     * Devuelve el número de elementos
     * @return el tamaño
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve si esta vacio
     * @return si esta vacio
     */
    public boolean empty() {
        return size == 0;
    }
}
