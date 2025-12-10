package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class GapBufferTests {
    @Test
    public void test1() {
        GapBuffer b = new GapBuffer();
        b.insert('a');
        b.insert('b');
        b.insert('c');
        assertEquals(3, b.getCursorPosition());
        assertEquals(3, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(1, b.arrow1);
        assertEquals(6, b.arrow2);
        assertEquals(2, b.getSize());
    }

    @Test
    public void test2() {
        GapBuffer b = new GapBuffer();
        b.delete();
        b.moveLeft();
        b.insert('a');
        b.insert('b');
        assertEquals(2, b.arrow1);
        assertEquals(2, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(2, b.arrow2);
        assertEquals(0, b.arrow1);
        assertEquals(1, b.sz);
    }

    @Test
    public void test3() {
        GapBuffer b = new GapBuffer();
        b.insert('a');
        b.insert('b');
        assertEquals('a', b.getChar(0));
        assertEquals('b', b.getChar(1));
        assertEquals(' ', b.getChar(2));
        assertEquals(' ', b.getChar(3));
        b.moveLeft();
        assertEquals('a', b.getChar(0));
        assertEquals(' ', b.getChar(1));
        assertEquals('b', b.getChar(2));
        assertEquals(' ', b.getChar(3));
        b.insert('c');
        assertEquals('c', b.getChar(1));
        assertEquals(' ', b.getChar(2));
        assertEquals(' ', b.getChar(3));
        assertEquals(' ', b.getChar(4));
        assertEquals(' ', b.getChar(5));
        assertEquals('b', b.getChar(6));
    }

    @Test
    public void helloExampleTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('h');
        buffer.insert('e');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('o');
        buffer.insert(' ');
        buffer.insert('w');
        buffer.insert('o');
        buffer.insert('r');
        buffer.insert('l');
        buffer.insert('d');
    
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.insert('!');
    
        buffer.moveLeft();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
    
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        assertEquals("abc! world", buffer.toString());
    }

    @Test
    public void test4() {
        GapBuffer b = new GapBuffer();
        b.insert('a');
        assertEquals('a', b.getChar(0));
        b.insert('b');
        b.insert('c');
        b.insert('d');
        b.moveLeft();
        assertEquals(3, b.arrow1);
        assertEquals(6, b.arrow2);
        assertEquals('d', b.getChar(6));
        b.moveRight();
        assertEquals(4, b.arrow1);
        assertEquals(7, b.arrow2);
        b.moveLeft();
        b.delete();
        assertEquals("ab    d ", b.toString());
    }

    @Property
    public boolean ArrowTest(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        GapBuffer b = new GapBuffer();
        int ArrowSum = 0;
        b.insert('a');
        ArrowSum += b.arrow1;
        b.insert('b');
        ArrowSum += b.arrow1;
        b.insert('c');
        ArrowSum += b.arrow1;
        b.moveLeft();
        ArrowSum += b.arrow1;
        ArrowSum += b.arrow2;
        b.moveRight();
        ArrowSum += b.arrow1;
        ArrowSum += b.arrow2;
        return ArrowSum == 24;
    }
}
