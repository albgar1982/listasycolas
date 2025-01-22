package com.ejercicio2;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Dado un String que solamente contiene los caracteres '(', ')', '{', '}', '[' y ']',
 * implementa un algoritmo para determinar si es válido.
 *
 * Ejemplo 1:
 *  Input: "([]){}"
 *  Output: true
 *
 * Ejemplo 2:
 *  Input: "({)}"
 *  Output: false
 */
public class ValidParenthesisSolution {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(getOpposite(c)); //Se mete el de cierre, NO el de apertura
      } else {
        if (stack.isEmpty() || stack.pop() != c) return false; // Aquí stack.pop() != c comprobamos que NO coincide el cierre con el que guardamos que tenía que ser
      }
    }

    return stack.isEmpty();
  }

  private char getOpposite(char c) {
    if (c == '(') return ')';
    if (c == '{') return '}';
    if (c == '[') return ']';

    return '0';
  }
}
