package org.example.impl;

import org.example.Stack;

import java.util.EmptyStackException;

public class Pile implements Stack {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void push(double item) {

    }

    @Override
    public double peek() throws EmptyStackException {
        return 0;
    }

    @Override
    public double pop() throws EmptyStackException {
        return 0;
    }
}
