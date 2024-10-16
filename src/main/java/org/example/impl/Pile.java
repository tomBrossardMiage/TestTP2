package org.example.impl;

import org.example.Stack;

import java.util.ArrayList;
import org.example.exception.EmptyStackException;

public class Pile implements Stack {

    private ArrayList<Double> pile = new ArrayList<>();
    @Override
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    @Override
    public int getSize() {
        return pile.size();
    }

    @Override
    public void push(double item) {
        pile.add(item);
    }

    @Override
    public double peek() throws EmptyStackException {
        boolean empty = this.isEmpty();
        if(empty){
            throw new EmptyStackException("Pile vide, impossible de récupérer la valeur car inexistante");
        }
        return pile.getLast();
    }

    @Override
    public double pop() throws EmptyStackException {
        boolean empty = this.isEmpty();
        if(empty){
            throw new EmptyStackException("Pile vide, impossible de retirer la valeur car inexistante");
        }
        double value = this.peek();
        pile.removeLast();
        return value;
    }
}
