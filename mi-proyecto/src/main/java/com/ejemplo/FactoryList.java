package com.ejemplo;

//Esta clase implementará el patrón Factory para cuando se elige StackList eligiendo el tipo de lista a utilizar 1. Simplemente encadenada y 2. Doblemente enlazada.
public class FactoryList {
    public static Stack<Integer> getStackList(int tipo) {
        if (tipo == 1) {
            return new SingleLinked();
        } else if (tipo == 2) {
            return new DoubleLinked();
        } else {
            return null;
        }
    }
}
