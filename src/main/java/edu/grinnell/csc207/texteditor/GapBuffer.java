package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    public char[] b = {' ', ' ', ' ', ' '};
    public int arrow1 = 0;
    public int arrow2 = 3;
    public int sz = 4;

    GapBuffer(char[] b, int arrow1, int arrow2, int sz) {
        this.b = b;
        this.arrow1 = arrow1;
        this.arrow2 = arrow2;
        this.sz = sz;
    }

    /**
     * Adds more blank spaces to make room for the cursor if its beginning and ending locations are the same.
     */
    private void ensureCapacity() {
        if (arrow1 == arrow2) {
            b = Arrays.copyOf(b, sz + 4);
            this.arrow2 += 4;
            this.sz += 4;
            for (int i = arrow2; i < sz; i++) {
                b[i] = b[i - 4];
            }
            for (int i = arrow1; i < arrow2; i++) {
                b[i] = ' ';
            }
        }
    }


    /**
     * 
     * Adds a character into b on array1's current position, moving arrow1 to the right.
     * 
     * @param ch the character we are inserting into the array.
     */
    public void insert(char ch) {
        b[arrow1] = ch;
        arrow1++;
        ensureCapacity();
    }

    /** 
     * 
     * Deletes the character in b located to the left of arrow1.
     * 
     */
    public void delete() {
        if (arrow1 != 0) {
            b[arrow1 - 1] = ' ';
            arrow1--;
        }
    }

    /**
     * 
     * Tells us what index position of s the cursor is currently on.
     * 
     * @return the current index position of the cursor (arrow2).
     */
    public int getCursorPosition() {
        return this.arrow2;
    }


    /**
     * 
     * Moves the cursor to the right if possible on the array.
     * 
     */
    public void moveLeft() {
        if (this.arrow1 > 0) {
            b[arrow2] = b[arrow1 - 1];
            b[arrow1 - 1] = ' ';
            this.arrow1--;
            this.arrow2--;
        }
    }

    /**
     * Moves the cursor to the left if possible on the array.
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
     * Gives us the current size of the array.
     * @return the current size of the array.
     */
    public int getSize() {
        return sz;
    }

    /**
     * Gives us the character from a specific index in the array.
     * @param i the index from which we get our character from in the array.
     * @return the character on index i.
     */
    public char getChar(int i) {
        return b[i];
    }

    /**
     * Returns a string giving the current status of the backing string, arrow positions, and size.
     */
    public String toString() {
        String myString = "String representation of buffer b = " + this.b.toString() + ", Gap starting point = " + arrow1 + ", Gap ending point = " + arrow2 + ", Size = " + this.sz;
        return myString;
    }
}
