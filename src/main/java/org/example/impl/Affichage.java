package org.example.impl;

import org.example.RPNParser;
import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import java.util.EmptyStackException;

public class Affichage implements RPNParser {
    private Calculatrice calculette;
    private double result;
    public Affichage (){
        this.calculette = new Calculatrice();
    }
    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException, EmptyStackException {
        StringBuilder valTemp = new StringBuilder();
        for (int i = 0; i < toParse.length(); i++) {
            char c = toParse.charAt(i);
            switch (c) {
                case '+':
                    this.calculette.add();
                    result = calculette.displayValueOnTop();
                    break;
                case '-':
                    calculette.subtract();
                    result = calculette.displayValueOnTop();
                    break;
                case '*':
                    this.calculette.multiply();
                    result = calculette.displayValueOnTop();
                    break;
                case '/':
                    this.calculette.divide();
                    result = calculette.displayValueOnTop();
                    break;
                default:
                    if (c != ' ') {  // Si le caractère n'est pas un espace
                        valTemp.append(c);  // Ajouter le caractère à la sous-chaîne temporaire
                        if (estUnNombre(valTemp)) {
                            double valeur = Double.parseDouble(String.valueOf(c));
                            this.calculette.enterValue(valeur);
                            valTemp.setLength(0);  // Réinitialiser motTemp pour le prochain mot
                        } else {
                            System.out.println("la valeur n'est ni un chiffre ni une opérande, entrée non valide");
                        }
                        break;
                    }
            }
        }
        System.out.println("Résultat : " + result);
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
