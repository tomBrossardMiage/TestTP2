package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.impl.Calculatrice;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void EnterValue() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.enterValue(5.0);
        assertEquals("Le sommet de la pile doit être 5.0", 5.0, calc.displayValueOnTop());
    }

    @Test
    public void Add() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.enterValue(1.0);
        calc.enterValue(3.0);
        calc.enterValue(7.0);
        calc.add();
        assertEquals("Le résultat de 3 + 7 est 10", 10.0, calc.displayValueOnTop());
    }

    @Test
    public void Subtract() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.enterValue(120.0);
        calc.enterValue(10.0);
        calc.enterValue(4.0);
        calc.subtract();
        assertEquals("Le résultat de 10 - 4 est 6", 6.0, calc.displayValueOnTop());
    }

    @Test
    public void Multiply() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.enterValue(10.0);
        calc.enterValue(3.0);
        calc.enterValue(4.0);
        calc.multiply();
        assertEquals("Le résultat de 3 * 4 est 12", 12.0, calc.displayValueOnTop());
    }

    @Test
    public void Divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        Calc calc = new Calculatrice();
        calc.enterValue(5.0);
        calc.enterValue(10.0);
        calc.enterValue(2.0);
        calc.divide();
        assertEquals("Le résultat de 10 / 2 est 5", 5.0, calc.displayValueOnTop());
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testAddWithInsufficientOperands() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.enterValue(3.0);
        calc.add();
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testDisplayValueOnTopWhenEmpty() throws NotEnoughOperandsOnStackException {
        Calc calc = new Calculatrice();
        calc.displayValueOnTop();
    }

    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        Calc calc = new Calculatrice();
        calc.enterValue(3.0);
        calc.enterValue(0.0);
        calc.divide();
    }
}
