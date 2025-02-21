package com.ejemplo;

/**
 * Interfaz que define las operaciones básicas de una estructura de datos Stack (Pila).
 * Un Stack sigue el principio LIFO (Last In First Out) donde el último elemento añadido
 * es el primero en ser removido.
 * 
 * @param <E> El tipo de elementos que contendrá el Stack
 */
public interface Stack<E> {

   /**
    * Agrega un elemento al tope de la pila.
    * @param item Elemento a agregar.
    */
   public void push(E item);
   
   /**
    * Elimina y devuelve el elemento en el tope de la pila.
    * @return Elemento eliminado.
    * @throws IndexOutOfBoundsException si la pila está vacía.
    */
   public E pop();
   
   /**
    * Devuelve el elemento en el tope de la pila sin eliminarlo.
    * @return El elemento en el tope de la pila.
    * @throws IndexOutOfBoundsException si la pila está vacía.
    */
   public E peek();
   
   /**
    * Verifica si la pila está vacía.
    * @return true si la pila está vacía, false en caso contrario.
    */
   public boolean empty();
   
   /**
    * Devuelve el número de elementos en la pila.
    * @return Cantidad de elementos en la pila.
    */
   public int size();
}
