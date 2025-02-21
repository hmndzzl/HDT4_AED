package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class Tests {

    // Test StackArrayList
    @Test
    void testStackArrayList() {
        Stack<Integer> stack = new StackArrayList<>();
        assertTrue(stack.empty());
        
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
        
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }

    // Test StackList
    @Test
    void testStackList() {
        Stack<Integer> stack = new StackList<>();
        assertTrue(stack.empty());
        
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
        
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.empty());
    }

    // Test StackVector
    @Test
    void testStackVector() {
        Stack<Integer> stack = new StackVector<>();
        assertTrue(stack.empty());
        
        stack.push(100);
        stack.push(200);
        assertEquals(2, stack.size());
        assertEquals(200, stack.peek());
        
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());
        assertTrue(stack.empty());
    }

    // Test SingleLinked
    @Test
    void testSingleLinked() {
        SingleLinked list = new SingleLinked();
        assertTrue(list.empty());
        
        list.push(5);
        list.push(10);
        assertEquals(2, list.size());
        assertEquals(10, list.peek());
        
        assertEquals(10, list.pop());
        assertEquals(5, list.pop());
        assertTrue(list.empty());
    }

    // Test DoubleLinked
    @Test
    void testDoubleLinked() {
        DoubleLinked<Integer> list = new DoubleLinked<>();
        assertTrue(list.empty());
        
        list.push(50);
        list.push(100);
        assertEquals(2, list.size());
        assertEquals(100, list.peek());
        
        assertEquals(100, list.pop());
        assertEquals(50, list.pop());
        assertTrue(list.empty());
    }

    // Test edge cases
    @Test
    void testEmptyStackOperations() {
        Stack<Integer> stack = new StackArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
        assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
    }
}
