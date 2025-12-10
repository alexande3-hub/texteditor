package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;


public class SimpleStringBufferTests {
    @Test
    public void test1() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('a');
        b.insert('b');
        b.insert('c');
        assertEquals(3, b.index);
        assertEquals(3, b.getSize());
        b.moveLeft();
        b.delete();
        assertEquals(1, b.getCursorPosition());
        assertEquals(2, b.sz);
    }

    @Test
    public void test2() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.delete();
        b.moveLeft();
        b.insert('a');
        b.insert('b');
        assertEquals(2, b.index);
        assertEquals(2, b.sz);
        b.moveLeft();
        b.delete();
        assertEquals(0, b.index);
        assertEquals(1, b.sz);
    }

    @Test
    public void test3() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('a');
        assertEquals('a', b.getChar(0));
        b.insert('b');
        b.insert('c');
        b.insert('d');
        b.moveLeft();
        assertEquals(3, b.index);
        assertEquals('d', b.getChar(3));
        b.moveRight();
        assertEquals(4, b.index);
        b.moveLeft();
        b.delete();
        assertEquals("abd", b.s);
        assertEquals("abd", b.toString());
    }

    @Property
    public boolean IndexTest(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        SimpleStringBuffer b = new SimpleStringBuffer();
        int IndexSum = 0;
        b.insert('a');
        IndexSum += b.index;
        b.insert('b');
        IndexSum += b.index;
        b.insert('c');
        IndexSum += b.index;
        b.moveLeft();
        IndexSum += b.index;
        b.moveRight();
        IndexSum += b.index;
        return IndexSum == 11;
    }

}
