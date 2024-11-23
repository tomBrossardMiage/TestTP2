package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import org.example.impl.Affichage;
import org.example.impl.Calculatrice;
import org.example.impl.Pile;

import java.util.Scanner;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws EmptyStackException, DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {
        Pile pile = new Pile();
        Calculatrice calculatrice = new Calculatrice(pile);
        Affichage printer = new Affichage(calculatrice);
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("RPN Calc\n" + "Type '.exit' at any time to quit");
        while (true) {
            System.out.println("Input a RPN expression");
            System.out.print("->");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase(".exit")) {
                System.out.println("Fin du programme.");
                break;
            }
            try{
                printer.parseAndDisplayResult(input);
            }catch(DivideByZeroException exception){
                System.out.println("Divide by zero, Try again or type '.exit' to quit");
            }catch(NotEnoughOperandsOnStackException exception){
                System.out.println("Not enough operands, Try again or type '.exit' to quit");
            }catch(ParseException exception){
                System.out.println("Invalid Expression, Try again or type '.exit' to quit");
            }

        }
    }
}