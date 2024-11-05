package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import java.util.EmptyStackException;

public interface Calc {
    /**
     * pushes a value on the RPN stack
     * @param value
     */
    void enterValue(double value);
    /**
     * adds the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    void add() throws NotEnoughOperandsOnStackException, EmptyStackException;
    /**
     * subtracts the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    void subtract() throws NotEnoughOperandsOnStackException, EmptyStackException;
    /**
     * multiplies the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    void multiply() throws NotEnoughOperandsOnStackException, EmptyStackException;
    /**
     * divides the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     * @throws DivideByZeroException
     */
    void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException, EmptyStackException;
    /**
     * displays the last value on top of the stack
     * @return the last value
     * @throws NotEnoughOperandsOnStackException
     */
    double displayValueOnTop() throws NotEnoughOperandsOnStackException, EmptyStackException;
}
