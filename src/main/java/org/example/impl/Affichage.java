package org.example.impl;

import org.example.RPNParser;
import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import java.util.EmptyStackException;

public class Affichage implements RPNParser {
    private Calculatrice calculette;
    private double result;

    public Affichage (Calculatrice calculatrice){
        this.calculette = calculatrice;
    }
    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException, EmptyStackException {
        StringBuilder valTemp = new StringBuilder();
        int i = 0;
        while (i < toParse.length()) {
            char c = toParse.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                switch (c) {
                    case '+':
                        calculette.add();
                        break;
                    case '-':
                        calculette.subtract();
                        break;
                    case '*':
                        calculette.multiply();
                        break;
                    case '/':
                        calculette.divide();
                        break;
                }
                result = calculette.displayValueOnTop();
                i++;
            } else {
                // Gestion des nombres : accumulation des chiffres jusqu'à l'espace ou fin de chaîne
                valTemp.setLength(0); // Réinitialiser valTemp pour chaque nombre
                while (i < toParse.length() && !Character.isWhitespace(toParse.charAt(i)) && "+-*/".indexOf(toParse.charAt(i)) == -1) {
                    valTemp.append(toParse.charAt(i));
                    i++;
                }

                // Convertir le contenu de valTemp en nombre et le pousser dans la calculatrice
                if (estUnNombre(valTemp)) {
                    double valeur = Double.parseDouble(valTemp.toString());
                    calculette.enterValue(valeur);
                } else {
                    throw new ParseException("La valeur '" + valTemp + "' n'est ni un nombre ni une opérande valide.");
                }
            }
        }

        System.out.println(result);
        return result;
    }

    public static boolean estUnNombre(StringBuilder texte) {
        try {
            Double.parseDouble(String.valueOf(texte));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
