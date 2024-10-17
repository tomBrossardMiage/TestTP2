package org.example.impl;

import org.example.Calc;
import org.example.Stack;
import org.example.exception.DivideByZeroException;
import org.example.exception.EmptyStackException;
import org.example.exception.NotEnoughOperandsOnStackException;

public class Calculatrice implements Calc {
    Stack pile;

    public Calculatrice(){
        pile = new Pile();
    }
    @Override
    public void enterValue(double value) {
        pile.push(value);
    }

    @Override
    public void add() throws NotEnoughOperandsOnStackException, EmptyStackException {
        double value1;
        double value2;
        double result;
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException("Il est nécessaire d'avoir au minimum deux valeurs disponible dans la pile pour pouvoir faire une opération.");
        }
        value2 = pile.pop();
        value1 = pile.pop();
        result = value1 + value2;
        pile.push(result);
    }

    @Override
    public void subtract() throws NotEnoughOperandsOnStackException, EmptyStackException {
        double value1;
        double value2;
        double result;
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException("Il est nécessaire d'avoir au minimum deux valeurs disponible dans la pile pour pouvoir faire une opération.");
        }
        value2 = pile.pop();
        value1 = pile.pop();
        result = value1 - value2;
        pile.push(result);
    }

    @Override
    public void multiply() throws NotEnoughOperandsOnStackException, EmptyStackException {
        double value1;
        double value2;
        double result;
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException("Il est nécessaire d'avoir au minimum deux valeurs disponible dans la pile pour pouvoir faire une opération.");
        }
        value2 = pile.pop();
        value1 = pile.pop();
        result = value1 * value2;
        pile.push(result);
    }

    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException, EmptyStackException {
        double value1;
        double value2;
        double result;
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException("Il est nécessaire d'avoir au minimum deux valeurs disponible dans la pile pour pouvoir faire une opération.");
        }
        value2 = pile.pop();
        value1 = pile.pop();
        if(value2 == 0){
            throw new DivideByZeroException("Division par zéro impossible.");
        }
        result = value1/value2;
        pile.push(result);
    }

    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException, EmptyStackException {
        if(pile.isEmpty()){
            throw new NotEnoughOperandsOnStackException("impossible d'afficher une valeur. La pile est vide.");
        }
        return pile.peek();
    }
}
