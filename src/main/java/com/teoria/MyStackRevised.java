package com.teoria;

public class MyStackRevised {
    private Node top;

    public void push(int value) {
        Node newTop = new Node(value); //se crea un nuevo nodo con el valor pasado
        newTop.next = top; //Se hace que su next sea el top anterior
        top = newTop; //Se asigna este nuevo nodo como tope
    }

    public int pop() {
        int topValue = peek();
        top = top.next; //Se hace que el nuevo tope sea el que era el segundo desde arriba. El nodo que era el top antes, desaparece, ya no es apuntado por ninguna referencia
        return topValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new MyEmptyStackException();
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
