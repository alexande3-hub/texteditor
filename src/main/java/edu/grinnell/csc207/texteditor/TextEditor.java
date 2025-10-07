package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        String st = buf.b.toString();
        for (int i = 0; i < buf.sz; i++) {
            TextCharacter c = TextCharacter.fromCharacter(buf.getChar(i));
            screen.setCharacter(i, 0, c);
        }
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();

        String path = args[0];
        System.out.format("Loading %s...\n", path);

        Path newPath = Paths.get(path);
        char[] bc = {' ', ' ', ' ', ' '};
        GapBuffer buf = new GapBuffer(bc, 0, 3, 4);
        TerminalPosition pos = new TerminalPosition(0, 0);
        screen.setCursorPosition(pos);
        boolean isRunning = true;
        while (isRunning) {
         KeyStroke stroke = screen.readInput();
            if (stroke.getKeyType() == KeyType.ArrowLeft) {
                buf.moveLeft();
            } else if (stroke.getKeyType() == KeyType.ArrowRight) {
                buf.moveRight();
            } else if (stroke.getKeyType() == KeyType.Backspace) {
                buf.delete();
            } else if (stroke.getKeyType() == KeyType.Character) {
                buf.insert(stroke.getCharacter());
            } else if (stroke.getKeyType() == KeyType.Escape) {
                isRunning = false;
            } drawBuffer(buf, screen);
        }
        screen.stopScreen();
        if (Files.exists(newPath) && Files.isRegularFile(newPath)) {
            Files.writeString(newPath, buf.b.toString());
        }
    }
}
