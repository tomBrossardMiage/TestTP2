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
        result = 0;
    }
    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException, EmptyStackException {
        StringBuilder valTemp = new StringBuilder();
        for (int i = 0; i < toParse.length(); i++) {
            char c = toParse.charAt(i);
            if (c != ' ') {  // Si le caractère n'est pas un espace
                valTemp.append(c);  // Ajouter le caractère à la sous-chaîne temporaire
            } else if (!valTemp.isEmpty()) {  // Si un espace est rencontré et que valTemp n'est pas vide
                if (estUnChiffre(toParse)) {
                    double valeur = Double.parseDouble(toParse);
                    this.calculette.enterValue(valeur);
                    valTemp.setLength(0);  // Réinitialiser motTemp pour le prochain mot
                } else {
                    switch (toParse) {
                        case "+":
                            this.calculette.add();
                            result =  calculette.getPile().peek();
                        case "-":
                            this.calculette.subtract();
                            result =  calculette.getPile().peek();
                        case "*":
                            this.calculette.multiply();
                            result =  calculette.getPile().peek();
                        case "/":
                            this.calculette.divide();
                            result =  calculette.getPile().peek();
                        default:
                            System.out.println("la valeur n'est ni un chiffre ni une opérande");
                    }
                }
            }
        }
        return result;
    }

    public static boolean estUnChiffre(String texte) {
        try {
            Double.parseDouble(texte);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
