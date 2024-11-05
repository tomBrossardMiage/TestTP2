package org.example;

import org.example.impl.Pile;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void isEmpty() {
        Pile pilvevide = new Pile();
        assertTrue("La pile doit être vide après sa création", pilvevide.isEmpty());

        pilvevide.push(10.0);
        assertFalse("La pile ne doit pas être vide après avoir ajouté un élément", pilvevide.isEmpty());

        pilvevide.pop();
        assertTrue("La pile doit être vide après avoir retiré tous les éléments", pilvevide.isEmpty());
    }

    @Test
    public void getSize() {
        Pile pileTaille = new Pile();
        assertEquals("La taille de la pile doit être 0 après sa création",0, pileTaille.getSize());

        pileTaille.push(10);
        pileTaille.push(20);
        assertEquals(2, pileTaille.getSize());

        pileTaille.pop();
        assertEquals("La taille de la pile doit être 1 après un pop", 1, pileTaille.getSize());

        pileTaille.pop();
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments",0, pileTaille.getSize());

    }

    @Test
    public void push() {
        Pile pilePush = new Pile();
        pilePush.push(10);
        assertEquals( "La taille de la pile doit être 1 après un push",1, pilePush.getSize());

        pilePush.push(20);
        assertEquals("La taille de la pile doit être 2 après deux push",2, pilePush.getSize());

    }

    @Test
    public void peek() {
        Pile pilePeek = new Pile();

        pilePeek.push(10);
        pilePeek.push(20);

        assertEquals("Peek doit retourner le dernier élément empilé",20, pilePeek.peek());
        assertEquals("La taille de la pile ne doit pas changer après un peek",2, pilePeek.getSize());

        pilePeek.pop();
        pilePeek.pop();
        assertThrows("Peek sur une pile vide doit lever EmptyStackException",EmptyStackException.class, pilePeek::peek);

    }

    @Test
    public void pop() {
        Pile pilePop = new Pile();
        pilePop.push(10);
        pilePop.push(20);

        assertEquals( "Pop doit retourner l'élément suivant", 20, pilePop.pop());
        assertEquals("La taille de la pile doit être 1 après deux pops",1, pilePop.getSize());

        assertEquals("Pop doit retourner le dernier élément",10, pilePop.pop());
        assertEquals("La taille de la pile doit être 0 après avoir retiré tous les éléments", 0, pilePop.getSize());

        assertThrows("Pop sur une pile vide doit lever EmptyStackException",EmptyStackException.class, pilePop::pop);

    }
}