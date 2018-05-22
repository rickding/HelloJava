package com.hello.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello dialog!
 */
public class App {
    public static void main(String[] args) {
        // create frame
        final JFrame frame = new JFrame("Hello Dialog");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Create buttons
        JButton btn = new JButton("Show Dialog");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDialog(frame, frame);
            }
        });

        // create panel
        JPanel panel = new JPanel();
        panel.add(btn);

        // Show panel
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    /**
     * Show dialog
     * @param owner
     * @param parentComponnent
     */
    private static void showDialog(Frame owner, Component parentComponnent) {
        // create dialog
        final JDialog dialog = new JDialog(owner, "Info", true);
        dialog.setSize(250, 150);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponnent);

        // create content
        JLabel label = new JLabel("Message");
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close dialog
                dialog.dispose();
            }
        });

        // Add to panel
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(btn);

        // Show panel in dialog
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }
}
