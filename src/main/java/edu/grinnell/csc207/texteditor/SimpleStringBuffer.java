package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    private String s;
    private int index;
    private int sz;

    SimpleStringBuffer() {
        this.s = s;
        this.index = index;
        this.sz = sz;
    }

    public void insert(char ch) {
        s += " ";
        char[] sArray = s.toCharArray();
        sz++;
        for (int i = (sz - 1); i > index; i--) {
            sArray[i] = sArray[i - 1];
        } sArray[index] = ch;
        s = sArray.toString();
    }

    public void delete() {
        if (sz != 0) {
            char[] sArray = s.toCharArray();
            for (int i = index; i < (sz - 1); i++) {
                sArray[i] = sArray[i + 1];
            } s = sArray.toString();
            s = s.substring(0, (sz - 1));
            sz--;
        }
    }

    public int getCursorPosition() {
        return index;
    }

    public void moveLeft() {
        if (index > 0) {
            index--;
        }
    }

    public void moveRight() {
        if (index < (sz - 1)) {
            index++;
        }
    }

    public int getSize() {
        return sz;
    }

    public char getChar(int i) {
        return s.toCharArray()[i];
    }

    @Override
    public String toString() {
        String myString = "String = " + s + ", Index = " + index + ", Size = " + sz;
        return myString;
    }
}
