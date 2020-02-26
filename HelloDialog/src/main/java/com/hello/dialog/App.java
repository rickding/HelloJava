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

        // create panel
        JPanel panel = new JPanel();
        Box verticalBox = Box.createVerticalBox();
        panel.add(verticalBox);

        // Create buttons
        verticalBox.add(new JButton("Record") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Record audio
                }
            });
        }});

        verticalBox.add(new JButton("About") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showDialog(frame, frame);
                }
            });
        }});

        // Show panel
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private static void showDialog(Frame owner, Component parentComponnent) {
        // create dialog
        final JDialog dialog = new JDialog(owner, "Info", true);
        dialog.setSize(250, 150);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponnent);

        // Add list
        Box verticalBox = Box.createVerticalBox();

        // create content
        verticalBox.add(new JLabel("Message"));
        verticalBox.add(new JButton("OK") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // close dialog
                    dialog.dispose();
                }
            });
        }});

        // Add to panel
        JPanel panel = new JPanel();
        panel.add(verticalBox);

        // Show panel in dialog
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }
}
