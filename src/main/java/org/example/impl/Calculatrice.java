package org.example.impl;

import org.example.Calc;
import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;

public class Calculatrice implements Calc {
    @Override
    public void enterValue(double value) {
    }

    @Override
    public void add() throws NotEnoughOperandsOnStackException {

    }

    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {

    }

    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {

    }

    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {

    }

    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        return 0;
    }
}
