package com.hello.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog {
    public static void showDialog(JFrame owner, Component parentComponnent) {
        // create dialog
        final JDialog dialog = new JDialog(owner, "Hello Dialog", true);
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
