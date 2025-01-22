package com.ejercicio3;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortStackTest {

  @Test
  public void sortStackTest() {
    SortStackSolution sortStack = new SortStackSolution();

    /*
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(1);
    stack.push(5);
    stack.push(2);
    stack.push(4);
    Deque<Integer> sortedStack = sortStack.sort(stack);

    assertEquals(1, sortedStack.pop());
    assertEquals(2, sortedStack.pop());
    assertEquals(4, sortedStack.pop());
    assertEquals(5, sortedStack.pop());

     */

    Deque<Integer> deque2 = new ArrayDeque<>(); //Aquí se van metiendo, primero los mayores
    deque2.push(1);
    deque2.push(5);
    deque2.push(4);
    deque2.push(2);

    System.out.println("Initial deque2: " + deque2);


    Deque<Integer> sortedStack2 = sortStack.sort(deque2);

    assertEquals(1, sortedStack2.pop());
    assertEquals(2, sortedStack2.pop());
    assertEquals(4, sortedStack2.pop());
    assertEquals(5, sortedStack2.pop());
  }
}
