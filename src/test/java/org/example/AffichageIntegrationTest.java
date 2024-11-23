package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import org.example.impl.Affichage;
import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AffichageIntegrationTest {

    private Affichage affichage;
    @Before
    public void setUp(){
        Pile pile = new Pile();
        Calculatrice calculatrice = new Calculatrice(pile);
        affichage = new Affichage(calculatrice);
    }

    @Test
    public void testEstUnNombreValide() {
        assertTrue("Doit retourner true pour un nombre entier", Affichage.estUnNombre(new StringBuilder("123")));
        assertTrue("Doit retourner true pour un nombre décimal", Affichage.estUnNombre(new StringBuilder("123.45")));
        assertTrue("Doit retourner true pour un nombre négatif", Affichage.estUnNombre(new StringBuilder("-123.45")));
    }

    @Test
    public void testEstUnNombreInvalide() {
        assertFalse("Doit retourner false pour une chaîne contenant des lettres", Affichage.estUnNombre(new StringBuilder("123abc")));
        assertFalse("Doit retourner false pour une chaîne vide", Affichage.estUnNombre(new StringBuilder("")));
        assertFalse("Doit retourner false pour une chaîne contenant un espace", Affichage.estUnNombre(new StringBuilder(" ")));
    }

    @Test
    public void testParseAndDisplayResult() throws DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {

        //calcul classique
        assertEquals(13, affichage.parseAndDisplayResult("3 5 2*+"),0.1);
        assertEquals(-10, affichage.parseAndDisplayResult("10 20-"),0.1);
        assertEquals(0.5, affichage.parseAndDisplayResult("10 20/"),0.1);
        assertEquals(4, affichage.parseAndDisplayResult("1 1 1 1+++"),0.1);
    }

    @Test(expected = DivideByZeroException.class)
    public void testParseAndDisplayResultDivideByZero() throws DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {
        affichage.parseAndDisplayResult("2 0/");
    }

    @Test(expected = NotEnoughOperandsOnStackException.class)
    public void testParseAndDisplayResultNotEnoughOperandsOnStack() throws DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {
        affichage.parseAndDisplayResult("2+");
    }

    @Test(expected = ParseException.class)
    public void testParseAndDisplayResultParse() throws DivideByZeroException, NotEnoughOperandsOnStackException, ParseException {
        affichage.parseAndDisplayResult("a");
    }

}
