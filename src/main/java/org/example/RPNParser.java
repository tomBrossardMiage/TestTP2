package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.EmptyStackException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;

public interface RPNParser {
    /**
     * parses the string, computing and display the last result
     * @param toParse
     * @return the last result
     */
    double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException, EmptyStackException;
}
