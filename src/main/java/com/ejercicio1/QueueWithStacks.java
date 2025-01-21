package com.ejercicio1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implementa una clase MyQueue utilizando dos stacks.
 *
 * Como Stack usaremos la Interfaz Deque, que proporciona las operaciones de una cola doblemente terminada,
 * permitiéndola usar como Pila o Cola (solo las operaciones de Pila están permitidas en este ejercicio).
 *
 * Java también tiene la clase Stack, pero su uso no está recomendado por extender de la clase Vector, que
 * no tiene demasiado sentido, y por ser una clase específica y no una interfaz. Si quieres saber más sobre
 * este tema puedes acceder al siguiente enlace:
 * https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
 */
public class QueueWithStacks {
    Deque<Integer> firstStack = new ArrayDeque<>();
    Deque<Integer> secondStack = new ArrayDeque<>();

    public void add(Integer value) {
        firstStack.push(value);
    }

    public Integer peek() {
        if(!secondStack.isEmpty()) //Si quedan elementos en la segunda pila, YA estarán ordenados
            return secondStack.peek(); //Así que devolvemos el de arriba
        while(!firstStack.isEmpty())
            secondStack.push(firstStack.pop());
        return secondStack.peek();
    }

    public Integer remove() {
        if(!secondStack.isEmpty()) //Si quedan elementos en la segunda pila, YA estarán ordenados
            return secondStack.pop(); //Así que quitamos -y devolvemos- el de arriba
        while(!firstStack.isEmpty())
            secondStack.push(firstStack.pop());
        return secondStack.pop();
    }

    public boolean isEmpty() {
        return firstStack.size() == 0;
    }

    public int size() {
        return firstStack.size() + secondStack.size();
    }

    public static void main(String[] args) {
        QueueWithStacks queueWithStacks = new QueueWithStacks();

        queueWithStacks.add(15);
        queueWithStacks.add(3);
        queueWithStacks.add(99);
        queueWithStacks.add(37);

        System.out.println(queueWithStacks.size());
        System.out.println(queueWithStacks.isEmpty());
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.size());
        System.out.println(queueWithStacks.peek());
        System.out.println(queueWithStacks.size());
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.peek());
        queueWithStacks.add(28);
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.peek());
        queueWithStacks.add(50);
        System.out.println(queueWithStacks.remove());
    }
}