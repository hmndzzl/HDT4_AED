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
     * Agrega un elemento al stack
     * @param item lo que se agregara
     */
    public void push(int item) {
        primero = new Nodo(item, primero);
        size++;
    }

    /**
     * borra y devuelve el ultimo elemento añadido
     * @return lo eliminado
     * @throws IndexOutOfBoundsException si no hay nada
     */
    public int pop() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        int item = primero.dato;
        primero = primero.siguiente;
        size--;
        return item;
    }

    /**
     * Devuelve el ultimo dato ingresado
     * @return lo ultimo del stack
     * @throws IndexOutOfBoundsException si esta vacio
     */
    public int peek() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        return primero.dato;
    }

    /**
     * Devuelve el numero de elementos
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
