package org.example;

import org.example.exception.DivideByZeroException;
import org.example.exception.NotEnoughOperandsOnStackException;
import org.example.exception.ParseException;
import org.example.impl.Affichage;
import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AffichageUnitTest {

    Calculatrice calculatriceMock;
    private Affichage affichage;
    @Before
    public void setUp(){
        Calculatrice calculatrice = Mockito.mock(Calculatrice.class);
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

}
