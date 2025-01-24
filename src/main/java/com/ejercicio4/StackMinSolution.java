package com.ejercicio4;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Esta solución es regulera del to.do
 */
public class StackMinSolution {

    private Deque<Integer> valuesStack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(Integer data) {
        valuesStack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    public int pop() {
        int oldTopData = valuesStack.pop();
        if (oldTopData == minStack.peek()) {
            minStack.pop();
        }
        return oldTopData;
    }

    public int min() {
        return minStack.peek();
    }
}
