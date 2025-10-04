package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    public String s;
    public int index;
    public int sz;

    SimpleStringBuffer() {
        this.s = " ";
        this.index = 0;
        this.sz = 0;
    }
    /**
     * 
     * Adds a character into s on the cursor's current position, increasing the size by 1 and moving the cursor to the right.
     * 
     * @param ch the character we are inserting into the string.
     */
    public void insert(char ch) {
        this.s += " ";
        char[] sArray = s.toCharArray();
        this.sz++;
        for (int i = (sz - 1); i > this.index; i--) {
            sArray[i] = sArray[i - 1];
        } sArray[this.index] = ch;
        s = sArray.toString();
        moveRight();
    }
    /** 
     * 
     * Deletes the character in s from the cursor's current position, decreasing the size by 1 and moving the cursor to the left when possible.
     * 
     */
    public void delete() {
        if (sz != 0) {
            char[] sArray = s.toCharArray();
            for (int i = index; i < (sz - 1); i++) {
                sArray[i] = sArray[i + 1];
            } s = sArray.toString();
            s = s.substring(0, (sz - 1));
            sz--;
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
     * Moves the cursor to the right if possible on the string.
     * 
     */
    public void moveLeft() {
        if (this.index > 0) {
            this.index--;
        }
    }
    /**
     * Moves the cursor to the left if possible on the string.
     */
    public void moveRight() {
        if (this.index < (sz - 1)) {
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
        return s.toCharArray()[i];
    }

    /**
     * Returns a string giving the current status of the backing string, index, and size.
     */
    @Override
    public String toString() {
        String myString = "String = " + this.s + ", Index = " + this.index + ", Size = " + this.sz;
        return myString;
    }
}
