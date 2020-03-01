package com.hello.dialog;


import javax.swing.*;

/**
 * Hello dialog!
 */
public class App {
    public static void main(String[] args) {
        // create frame
        final JFrame frame = new Frame();
        frame.setTitle("Hello App");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
