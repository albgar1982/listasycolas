package com.ejercicio2;

import java.util.Stack;

/*
Toda la lógica se basa en que los símbolos han de cerrarse en el sentido opuesto al que se abrieron.
Si la cadena va "[[( ha de cerrarse )]]", no pudiendo salir el cierre de corchete ANTES que el de paréntesis
En la pila se guardan en orden los de apertura, quedando
(
[
[

Ahora, si viene un cierre, tiene que coincidir con el stack.pop()
 */
public class ValidParenthesis {
    public boolean isValid(String cadena) {
        Stack<Character> stack = new Stack<>();

        // Recorrer la cadena carácter por carácter
        for (char simbolo : cadena.toCharArray()) {
            if ( esSimboloDeApertura(simbolo) )  // Si es un símbolo de apertura (En el else está la lógica para los de cierre)
                stack.push(simbolo); //Se añade a la pila (siempre quedará arriba)
            else if( stack.isEmpty()  // Si la pila está vacía, significa que no hemos metido ninguna apertura, así que el símbolo que metemos (el de cierre), es el primero, siendo esto un caso a rechazar "}()[]()" por ejemplo. Otra opción es que ya se haya cerrado algo anterior y luego salga primero un cierre, por ejemplo pasaría con "{})"
                     || !coincidenAperturaYCierre(stack.pop(),simbolo) ) //O si no casan la apertura y el cierre
                return false;
        }
        // La secuencia es válida si la pila está vacía al finalizar. Imagina el caso "[](" -> iría bien, pero en realidad el paréntesis quedaría sin cerrar y estaría MAL
        return stack.isEmpty();
    }

    private boolean esSimboloDeApertura(char simbolo) {
        return simbolo == '(' || simbolo == '[' || simbolo == '{';
    }

    private boolean coincidenAperturaYCierre(char apertura, char cierre) {
        return ( ( apertura == '(' && cierre == ')' )
                 || ( apertura == '[' && cierre == ']' )
                 || ( apertura == '{' && cierre == '}' ) );
    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();

        // Ejemplos de prueba
        System.out.println(vp.isValid("()"));        // true
        System.out.println(vp.isValid("()[]{}"));    // true
        System.out.println(vp.isValid("(]"));        // false
        System.out.println(vp.isValid("([)]"));      // false
        System.out.println(vp.isValid("{[]}"));      // true
        System.out.println(vp.isValid("{()[()()]}"));// true
    }
}
