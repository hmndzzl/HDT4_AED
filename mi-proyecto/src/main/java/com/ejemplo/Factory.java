package com.ejemplo;

//Esta clase implementará el patrón Factory para los stacks eligiendo el tipo de stack a utilizar.
public class Factory {
    public static Stack<Integer> getStack(int tipo) {
        if (tipo == 1) {
            return new StackArrayList<>();
        } else if (tipo == 2) {
            return new StackVector<>();
        } else if (tipo == 3) {
            return new StackList<>();
        } else {
            return null;
        }
    }
}
