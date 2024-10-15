package org.example;

import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {
    Calc calculatrice;
    Stack pile;
    @Before
    public void setUp(){
        calculatrice = new Calculatrice();
        pile = new Pile();
    }
    @Test
    public void enterValue() {
        double value = 10;
        calculatrice.enterValue(value);


    }

    @Test
    public void add() {
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void displayValueOnTop() {
    }
}