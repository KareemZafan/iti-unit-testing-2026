package org.iti.tests;

import org.iti.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushToStack() {
        assertTrue(myStack.isEmpty());
        myStack.push(1).push(2).push(3).push(4).push(1000);
        assertEquals(1000, myStack.getStackPeek());
        assertEquals(5, myStack.getStackSize());
        assertEquals(List.of(1, 2, 3, 4, 1000), myStack.getStackElements());
        System.out.println(myStack.getStackElements());
    }

    @Test
    void testPopFromStack() {

        assertTrue(myStack.isEmpty());
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Stack is empty", ex.getMessage());

        myStack.push(1).push(2).push(3).push(500).push(1000);

        int poppedElement = myStack.pop();
        assertEquals(1000, poppedElement);
        assertEquals(500, myStack.getStackPeek());
        assertEquals(4, myStack.getStackSize());
        assertEquals(List.of(1, 2, 3, 500), myStack.getStackElements());
        System.out.println(myStack.getStackElements());

    }

    @Test
    void testPeekOfStack() {
        assertTrue(myStack.isEmpty());
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.getStackPeek());
        assertEquals("Stack is empty", ex.getMessage());

        myStack.push(1)
                .push(2)
                .push(3)
                .push(4)
                .push(1000)
                .pop();
        assertEquals(4, myStack.getStackPeek());
        myStack.push(12000);
        assertEquals(12000, myStack.getStackPeek());

    }


}
