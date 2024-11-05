package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.EmptyStackException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import org.example.impl.Affichage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyStackException, DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {
        Affichage printer = new Affichage();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("RPN Calc\n" + "Type '.exit' at any time to quit");

        while (true) {
            System.out.print("Entrée : ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase(".exit")) {
                System.out.println("Fin du programme.");
                break;
            }
            printer.parseAndDisplayResult(input);

        }
    }
}