package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    public String s = "";
    public int index = 0;
    public int sz = 0;

    SimpleStringBuffer(String s, int index, int sz) {
        this.s = s;
        this.index = index;
        this.sz = sz;
    }
    
    /**
     * 
     * Adds a character into s on the cursor's current position, increasing the size by 1 and moving the cursor to the right.
     * 
     * @param ch the character we are inserting into the string.
     */
    public void insert(char ch) {
        char[] sArray = this.s.toCharArray();
        this.sz++;
        if (sArray == null) {
            char[] newArray = {ch};
            sArray = newArray;
        } else {
            sArray = Arrays.copyOf(sArray, sz);
            for (int i = (sz - 1); i > this.index; i--) {
                sArray[i] = sArray[i - 1];
            } sArray[this.index] = ch;
        } this.s = String.valueOf(sArray);
        moveRight();
    }

    /** 
     * 
     * Deletes the character in s from the cursor's current position, decreasing the size by 1 and moving the cursor to the left when possible.
     * 
     */
    public void delete() {
        if (this.sz != 0) {
            char[] sArray = this.s.toCharArray();
            for (int i = (index - 1); i < (sz - 1); i++) {
                sArray[i] = sArray[i + 1];
            } this.s = String.valueOf(sArray);
            this.s = this.s.substring(0, (sz - 1));
            this.sz--;
            moveLeft();
        }
    }
    /**
     * 
     * Tells us what index position of s the cursor is currently on.
     * 
     * @return the current index position of the cursor.
     */
    public int getCursorPosition() {
        return this.index;
    }

    /**
     * 
     * Moves the cursor to the left if possible on the string.
     * 
     */
    public void moveLeft() {
        if (this.index > 0) {
            this.index--;
        }
    }
    /**
     * Moves the cursor to the right if possible on the string.
     */
    public void moveRight() {
        if (this.index < sz) {
            this.index++;
        }
    }

    /**
     * Gives us the current size of the string.
     * @return the current size of the string.
     */
    public int getSize() {
        return this.sz;
    }

    /**
     * Gives us the character from a specific index in the string.
     * @param i the index from which we get our character from in the string.
     * @return the character on index i.
     */
    public char getChar(int i) {
        return s.charAt(i);
    }

    /**
     * Returns a string giving the current status of the buffer.
     * @return the current buffer.
     */
    @Override
    public String toString() {
        return s;
    }


}
