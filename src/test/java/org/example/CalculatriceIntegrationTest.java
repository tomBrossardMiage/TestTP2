package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatriceIntegrationTest {

    private Calc calc;

    @Before
    public void setUp() {
        Pile pile = new Pile();
        calc = new Calculatrice(pile);
    }

    @Test
    public void enterValueTestIntegration() throws NotEnoughOperandsOnStackException {
        calc.enterValue(5.0);
        assertEquals("Le sommet de la pile doit être 5.0", 5.0, calc.displayValueOnTop(), 0.1);
    }


    @Test
    public void addTest() throws NotEnoughOperandsOnStackException {
        calc.enterValue(1.0);
        calc.enterValue(3.0);
        calc.enterValue(7.0);
        calc.add();
        assertEquals("Le résultat de 3 + 7 est 10", 10.0, calc.displayValueOnTop(), 0.1);
    }

    @Test
    public void subtractTest() throws NotEnoughOperandsOnStackException {
        calc.enterValue(120.0);
        calc.enterValue(10.0);
        calc.enterValue(4.0);
        calc.subtract();
        assertEquals("Le résultat de 10 - 4 est 6", 6.0, calc.displayValueOnTop(), 0.1);
    }

    @Test
    public void multiplyTest() throws NotEnoughOperandsOnStackException {
        calc.enterValue(10.0);
        calc.enterValue(3.0);
        calc.enterValue(4.0);
        calc.multiply();
        assertEquals("Le résultat de 3 * 4 est 12", 12.0, calc.displayValueOnTop(), 0.1);
    }

    @Test
    public void divideTest() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(5.0);
        calc.enterValue(10.0);
        calc.enterValue(2.0);
        calc.divide();
        assertEquals("Le résultat de 10 / 2 est 5", 5.0, calc.displayValueOnTop(), 0.1);
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void addAvecUnSeulNombre() throws NotEnoughOperandsOnStackException {
        calc.enterValue(3.0);
        calc.add();
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void displayValueOnTopPileVide() throws NotEnoughOperandsOnStackException {
        calc.displayValueOnTop();
    }

    @Test(expected = DivideByZeroException.class)
    public void divideByZero() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        calc.enterValue(3.0);
        calc.enterValue(0.0);
        calc.divide();
    }
}

