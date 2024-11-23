package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.EmptyStackException;

import static org.mockito.Mockito.*;

public class CalculatriceUnitTest {
    Pile pileMock;
    Calculatrice calcMock;
    @Before
    public void setUp() {
        pileMock = Mockito.mock(Pile.class);
        calcMock = new Calculatrice(pileMock);

    }

    @Test
    public void enterValueTestUnitaire() throws NotEnoughOperandsOnStackException {
        calcMock.enterValue(5.0);
        verify(pileMock).push(5.0);
    }

    @Test
    public void addTest() throws NotEnoughOperandsOnStackException, EmptyStackException {
        when(pileMock.getSize()).thenReturn(2);
        when(pileMock.pop()).thenReturn(3.0).thenReturn(7.0);
        when(pileMock.isEmpty()).thenReturn(false);
        calcMock.add();
        verify(pileMock).getSize();
        verify(pileMock).push(10.0);
        verify(pileMock, times(2)).pop();
    }

    @Test
    public void substractTest() throws NotEnoughOperandsOnStackException, EmptyStackException {
        when(pileMock.getSize()).thenReturn(2);
        when(pileMock.pop()).thenReturn(3.0).thenReturn(7.0);
        when(pileMock.isEmpty()).thenReturn(false);
        calcMock.subtract();
        verify(pileMock).getSize();
        verify(pileMock).push(4.0);
        verify(pileMock, times(2)).pop();
    }

    @Test
    public void multiplyTest() throws NotEnoughOperandsOnStackException, EmptyStackException {
        when(pileMock.getSize()).thenReturn(2);
        when(pileMock.pop()).thenReturn(3.0).thenReturn(7.0);
        when(pileMock.isEmpty()).thenReturn(false);
        calcMock.multiply();
        verify(pileMock).getSize();
        verify(pileMock).push(21.0);
        verify(pileMock, times(2)).pop();
    }

    @Test
    public void divideTest() throws NotEnoughOperandsOnStackException, EmptyStackException, DivideByZeroException {
        when(pileMock.getSize()).thenReturn(2);
        when(pileMock.pop()).thenReturn(2.0).thenReturn(20.0);
        when(pileMock.isEmpty()).thenReturn(false);
        calcMock.divide();
        verify(pileMock).getSize();
        verify(pileMock).push(10.0);
        verify(pileMock, times(2)).pop();
    }

    @Test
    public void displayValueOnTopTest() throws NotEnoughOperandsOnStackException {
        when(pileMock.isEmpty()).thenReturn(false);
        calcMock.displayValueOnTop();
        verify(pileMock).peek();
    }

}
