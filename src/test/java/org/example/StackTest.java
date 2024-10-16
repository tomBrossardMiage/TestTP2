package org.example;

import org.example.impl.Calculatrice;
import org.example.impl.Pile;
import org.junit.Before;
import org.junit.Test;

import org.example.exception.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    Pile pile;

    @Before
    public void setUp(){
        pile = new Pile();
    }
    @Test
    public void isEmpty() throws EmptyStackException {
        assertTrue("La pile doit être vide après sa création", pile.isEmpty());

        pile.push(10.0);
        assertFalse("La pile ne doit pas être vide après avoir ajouté un élément", pile.isEmpty());

        pile.pop();
        assertTrue("La pile doit être vide après avoir retiré tous les éléments", pile.isEmpty());
    }

    @Test
    public void getSize() throws EmptyStackException {
        assertEquals("La taille de la pile doit être 0 après sa création",0, pile.getSize());

        pile.push(10);
        pile.push(20);
        assertEquals(2, pile.getSize());

        pile.pop();
        assertEquals("La taille de la pile doit être 1 après un pop", 1, pile.getSize());

        pile.pop();
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments",0, pile.getSize());

    }

    @Test
    public void push() {
        pile.push(10);
        assertEquals( "La taille de la pile doit être 1 après un push",1, pile.getSize());

        pile.push(20);
        assertEquals("La taille de la pile doit être 2 après deux push",2, pile.getSize());

    }

    @Test
    public void peek() throws EmptyStackException {
        pile.push(10);
        pile.push(20);

        assertEquals("Peek doit retourner le dernier élément empilé",20, pile.peek());
        assertEquals("La taille de la pile ne doit pas changer après un peek",2, pile.getSize());

        pile.pop();
        pile.pop();
        assertThrows("Peek sur une pile vide doit lever EmptyStackException",EmptyStackException.class, ()->{
            pile.peek();
        });

    }

    @Test
    public void pop() throws EmptyStackException {
        pile.push(10);
        pile.push(20);

        assertEquals( "Pop doit retourner l'élément suivant", 20, pile.pop());
        assertEquals("La taille de la pile doit être 1 après deux pops",1, pile.getSize());

        assertEquals("Pop doit retourner le dernier élément",10, pile.pop());
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments", 0, pile.getSize());

        assertThrows("Pop sur une pile vide doit lever EmptyStackException",EmptyStackException.class, ()->{
            pile.pop();
        });

    }
}