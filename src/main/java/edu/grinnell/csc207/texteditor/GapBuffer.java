package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    public char[] b = {};
    public int arrow1 = 0;
    public int arrow2 = 0;
    public int sz = 0;
    public int bufLength = 0;
    public boolean[] c = {};

    /**
     * A constructor for the GapBuffer.
     */
    public GapBuffer() {
        this.arrow1 = 0;
        this.arrow2 = 0;
        this.sz = 0;
        this.bufLength = 0;
    }

    /**
     * Adds more blank spaces to make room for the cursor.
     */
    private void ensureCapacity() {
        if (arrow1 == arrow2) {
            b = Arrays.copyOf(b, bufLength + 4);
            c = Arrays.copyOf(c, bufLength + 4);
            if (arrow1 == 0 && bufLength == 0) {
                arrow2 = 3;
                bufLength = 4;
                b[0] = ' ';
                b[1] = ' ';
                b[2] = ' ';
                b[3] = ' ';
                c[0] = false;
                c[1] = false;
                c[2] = false;
                c[3] = false;
            } else {
                this.arrow2 += 4;
                this.bufLength += 4;
                for (int i = bufLength - 1; i >= arrow2; i--) {
                    b[i] = b[i - 4];
                    c[i] = c[i - 4];
                }
                for (int i = arrow1; i < arrow2; i++) {
                    b[i] = ' ';
                    c[i] = false;
                }
            }
        }
    }


    /**
     * Adds a character into b on array1's current position, moving arrow1 to the right.
     * @param ch the character we are inserting into the array.
     */
    public void insert(char ch) {
        ensureCapacity();
        b[arrow1] = ch;
        c[arrow1] = true;
        arrow1++;
        sz++;
        ensureCapacity();
    }

    /** 
     * Deletes the character in b located to the left of arrow1.
     */
    public void delete() {
        if (arrow1 != 0) {
            b[arrow1 - 1] = ' ';
            c[arrow1 - 1] = false;
            arrow1--;
            sz--;
        }
    }

    /**
     * Tells us what index position of s the cursor is currently on.
     * @return the current index position of the cursor (arrow2).
     */
    public int getCursorPosition() {
        return this.arrow1;
    }


    /**
     * Moves the cursor to the right if possible on the array.
     */
    public void moveLeft() {
        if (this.arrow1 > 0) {
            b[arrow2 - 1] = b[arrow1 - 1];
            c[arrow2 - 1] = c[arrow1 - 1];
            b[arrow1 - 1] = ' ';
            c[arrow1 - 1] = false;
            this.arrow1--;
            this.arrow2--;
        }
    }


    /**
     * Moves the cursor to the left if possible on the array.
     */
    public void moveRight() {
        if (this.arrow2 < (bufLength - 1)) {
            b[arrow1] = b[arrow2];
            c[arrow1] = c[arrow2];
            b[arrow2] = ' ';
            c[arrow2] = false;
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
     * @return the string returned that holds the data.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < arrow1; i++) {
            str += b[i];
        }
        for (int i = arrow2; i < bufLength - 1; i++) {
            str += b[i];
        }
        return str;
    }
}
