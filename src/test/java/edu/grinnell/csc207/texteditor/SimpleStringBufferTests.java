package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class SimpleStringBufferTests {
    @Test
    public void test1() {
        SimpleStringBuffer b = new SimpleStringBuffer(" ", 0, 0);
        b.insert('a');
        b.insert('b');
        b.insert('c');
        assertEquals(2, b.index);
        assertEquals(3, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(0, b.index);
        assertEquals(2, b.sz);
    }
}
