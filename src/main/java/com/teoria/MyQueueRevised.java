package com.teoria;

/*
Esta clase es igual que la otra, ponla al lado para ver qué partes de código se han sustituido.
 */
public class MyQueueRevised {

    private Node first;
    private Node last;

    public void add(int value) {
        Node newLast = new Node(value); //Creamos un nuevo nodo con el valor pasado
        if (last != null) { //Si existía ya un last
            last.next = newLast; //Le ponemos el nuevo nodo a continuación (El next del anterior last apunta al nuevo)
        }

        last = newLast; //Sea como sea, pongo como último el nuevoUltimo

        if (isEmpty()) { //Si no hay first
            first = last; //El último es también el first
        }
    }

    public int remove() {

        int firstValue = peek(); //Guardamos el valor del first, que es lo que vamos a devolver al final
        first = first.next; //Asignamos como first su siguiente. El nodo que estaba como first quedará colgado y será recogido por el GarbageCollector

        if (isEmpty()) { //Si first es null tras esa asignación anterior (No había first.next)
            last = null; //Ponemos a null también last
        } //Evidentemente, si no había un segundo elemento (first.next), es que no había ningún nodo más allá de first, que es el que estamos
        //quitando, así que la cadena queda completamente vacía. Tanto first como last son ambos null de nuevo.

        return firstValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new MyEmptyQueueException();
        }

        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
