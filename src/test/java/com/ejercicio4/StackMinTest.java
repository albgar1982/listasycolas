package com.ejercicio4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackMinTest {

    @Test
    public void stackMinTest() {
        StackMin stackMin = new StackMin();

        stackMin.push(3);
        stackMin.push(1);
        stackMin.push(2);

        assertEquals(1, stackMin.min());
        stackMin.pop();
        assertEquals(1, stackMin.min());
        stackMin.pop();
        assertEquals(3, stackMin.min());
        stackMin.push(0);
        assertEquals(0, stackMin.min());
    }
}
