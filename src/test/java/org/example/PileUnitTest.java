package org.example;

import org.example.impl.Pile;
import org.junit.*;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class PileUnitTest {

    private Pile pile;

    @Before
    public void setUp() {
        pile = new Pile();
    }

    //TI
    @Test
    public void testIsEmpty() throws EmptyStackException {
        assertTrue("La pile doit être vide après sa création", pile.isEmpty());

        pile.push(10.0);
        assertFalse("La pile ne doit pas être vide après avoir ajouté un élément", pile.isEmpty());

        pile.pop();
        assertTrue("La pile doit être vide après avoir retiré tous les éléments", pile.isEmpty());
    }

    @Test
    public void testGetSize() throws EmptyStackException {
        assertEquals("La taille de la pile doit être 0 après sa création", 0, pile.getSize());

        pile.push(10);
        pile.push(20);
        assertEquals("La taille de la pile doit être 2 après deux push", 2, pile.getSize());

        pile.pop();
        assertEquals("La taille de la pile doit être 1 après un pop", 1, pile.getSize());

        pile.pop();
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments", 0, pile.getSize());
    }

    @Test
    public void testPush() {
        pile.push(10);
        assertEquals("La taille de la pile doit être 1 après un push", 1, pile.getSize());

        pile.push(20);
        assertEquals("La taille de la pile doit être 2 après deux push", 2, pile.getSize());
    }

    @Test
    public void testPeek() throws EmptyStackException {
        pile.push(10.0);
        pile.push(20.0);

        assertEquals("Peek doit retourner le dernier élément empilé", 20.0, pile.peek(), 0.1);
        assertEquals("La taille de la pile ne doit pas changer après un peek", 2, pile.getSize());

        pile.pop();
        pile.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack(){
        pile.peek();
    }

    @Test
    public void testPop() {
        pile.push(10);
        pile.push(20);

        assertEquals("Pop doit retourner l'élément suivant", 20.0, pile.pop(), 0.1);
        assertEquals("La taille de la pile doit être 1 après un pop", 1, pile.getSize());

        assertEquals("Pop doit retourner le dernier élément", 10.0, pile.pop(), 0.1);
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments", 0, pile.getSize());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack(){
        pile.pop();
    }
}