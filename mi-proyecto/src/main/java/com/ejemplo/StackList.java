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
     * Constructor 
     */
    public StackList() {
        ultimo = null;
        size = 0;
    }

    /**
     * Agrega un elemento al stack
     * @param item lo que se agregara
     */
    public void push(E item) {
        ultimo = new Nodo<>(item, ultimo);
        size++;
    }

    /**
     * borra y devuelve el ultimo elemento añadido
     * @return lo eliminado
     * @throws IndexOutOfBoundsException si no hay nada 
     */
    public E pop() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        E item = ultimo.dato;
        ultimo = ultimo.siguiente;
        size--;
        return item;
    }

    /**
     * Devuelve el ultimo dato ingresado
    //  * @return lo ultimo del stack
     * @throws IndexOutOfBoundsException si esta vacio
     */
    public E peek() {
        if (empty()) throw new IndexOutOfBoundsException("stack vacio");
        return ultimo.dato;
    }

    /**
     * Devuelve el numero de elementos
     * @return numero de datos
     */
    public int size() {
        return size;
    }

    /**
     * revisa si esta vacio
     * @return true o false si esta o no vacio el stack
     */
    public boolean empty() {
        return ultimo == null;
    }
}
