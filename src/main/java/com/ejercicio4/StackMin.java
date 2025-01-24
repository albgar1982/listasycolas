package com.ejercicio4;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * ¿Cómo diseñarías un Stack que además de las operaciones de push y pop también
 * contase con una operación para obtener el mínimo?
 */
public class StackMin {

    Deque<Integer> lista = new ArrayDeque<>();
    Deque<Integer> listaMinimos = new ArrayDeque<>();

    public void push(Integer data) {
        lista.push(data);

        //Si el número que meten en la lista es menor que el menor actual de la lista de mínimos, se añade a esta como nuevo mínimo
        //También se añade en el caso de que sea igual porque si no, en el caso de 2 números iguales en la lista, al quitar el mínimo de la lista de mínimos,
        // ya no se encontraría el otro que seguiría siendo el menor.
        // Por ejemplo, si en la lista hay 2,2,3 en la de mínimos ha de haber 2,2,3 también, porque si en esta última hubiese 2, 3, al quitar de la lista el primer 2,
        // lo quitaríamos de la segunda y habiendo 2, 3 en la lista, arrojaríamos 3 como el mínimo, y no 2
        if( listaMinimos.isEmpty() ||  data <= listaMinimos.peek() )
            listaMinimos.push(data);
    }

    public int pop() {
        if (lista.peek() != null && !listaMinimos.isEmpty() && lista.peek().intValue() == listaMinimos.peek().intValue())
            listaMinimos.pop();
        return lista.pop();
    }

    public int min() {
        return !listaMinimos.isEmpty()? listaMinimos.peek() : Integer.MAX_VALUE;
    }
}
