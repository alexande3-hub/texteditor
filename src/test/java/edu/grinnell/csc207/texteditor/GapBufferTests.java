package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GapBufferTests {
    @Test
    public void test1() {
        char[] bc = {' ', ' ', ' ', ' '};
        GapBuffer b = new GapBuffer(bc, 0, 3, 4);
        b.insert('a');
        b.insert('b');
        b.insert('c');
        assertEquals(7, b.getCursorPosition());
        assertEquals(8, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(6, b.arrow2);
        assertEquals(8, b.getSize());
    }

    @Test
    public void test2() {
        char[] bc = {' ', ' ', ' ', ' '};
        GapBuffer b = new GapBuffer(bc, 0, 3, 4);
        b.delete();
        b.moveLeft();
        b.insert('a');
        b.insert('b');
        assertEquals(2, b.arrow1);
        assertEquals(4, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(2, b.arrow2);
        assertEquals(0, b.arrow1);
        assertEquals(4, b.sz);
    }

    @Test
    public void test3() {
        char[] bc = {' ', ' ', ' ', ' '};
        GapBuffer b = new GapBuffer(bc, 0, 3, 4);
        b.insert('a');
        b.insert('b');
        b.moveLeft();
        b.insert('c');
        assertEquals('c', b.getChar(1));
        assertEquals(' ', b.getChar(6));
        assertEquals('b', b.getChar(7));
    }
}
