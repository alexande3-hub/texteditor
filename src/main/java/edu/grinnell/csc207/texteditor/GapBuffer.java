package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    public char[] b = {' ', ' ', ' ', ' '};
    public int arrow1 = 0;
    public int arrow2 = 3;
    public int sz = 0;

    GapBuffer(char[] b, int arrow1, int arrow2, int sz) {
        this.b = b;
        this.arrow1 = arrow1;
        this.arrow2 = arrow2;
        this.sz = sz;
    }


    private void ensureCapacity() {
        if (arrow1 == arrow2) {
            String bString = this.b.toString();
            String newString = bString.substring(0, arrow1) + "    " + bString.substring(arrow1, sz);
            b = newString.toCharArray();
            this.arrow2 += 4;
        }
    }



    public void insert(char ch) {
        ensureCapacity();
        b[arrow1] = ch;
        arrow1++;
    }

    public void delete() {
        b[arrow1 - 1] = ' ';
        arrow1--;
    }

    /**
     * 
     * Tells us what index position of s the cursor is currently on.
     * 
     * @return the current index position of the cursor.
     */
    public int getCursorPosition() {
        return this.arrow2;
    }


    /**
     * 
     * Moves the cursor to the right if possible on the string.
     * 
     */
    public void moveLeft() {
        if (this.arrow2 > 0) {
            b[arrow2] = b[arrow1 - 1];
            b[arrow1 - 1] = ' ';
            this.arrow1--;
            this.arrow2--;
        }
    }

    /**
     * Moves the cursor to the left if possible on the string.
     */
    public void moveRight() {
        if (this.arrow2 < (sz - 1)) {
            b[arrow1 - 1] = b[arrow2];
            b[arrow2] = ' ';
            this.arrow1++;
            this.arrow2++;
        }
    }

    /**
     * Gives us the current size of the string.
     * @return the current size of the string.
     */
    public int getSize() {
        return sz;
    }

    public char getChar(int i) {
        return b[i];
    }

    public String toString() {
        String myString = "String representation of buffer b = " + this.b.toString() + ", Gap starting point = " + arrow1 + ", Gap ending point = " + arrow2 + ", Size = " + this.sz;
        return myString;
    }
}
