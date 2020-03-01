package com.hello.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Frame extends JFrame {
    public Frame(){
        this.setTitle("Hello Frame");
        this.setSize(300, 300);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setVisible(true);

        // create panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        this.add(topPanel, BorderLayout.NORTH);

        // Create buttons
        topPanel.add(new JButton("Btn1"));
        topPanel.add(new JButton("Btn2"));
        topPanel.add(new JButton("Btn3"));

        // create panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        this.add(bottomPanel, BorderLayout.SOUTH);

        // Create buttons
        bottomPanel.add(new JButton("Btn4"), BorderLayout.NORTH);
        bottomPanel.add(new JButton("Btn5"), BorderLayout.CENTER);
        bottomPanel.add(new JButton("Btn6"), BorderLayout.WEST);
        bottomPanel.add(new JButton("Btn7"), BorderLayout.EAST);

        // create panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);

        Box verticalBox = Box.createVerticalBox();
        centerPanel.add(verticalBox, BorderLayout.CENTER);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Create buttons
        final JFrame frame = this;
        verticalBox.add(new JButton("Edit") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.insert(String.format("Edit %d: %s\n", textArea.getLineCount(), new Date().toString()), 0);
                }
            });
        }}, BorderLayout.NORTH);

        verticalBox.add(new JButton("About") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Dialog.showDialog(frame, frame);
                }
            });
        }}, BorderLayout.NORTH);

        verticalBox.add(textArea, BorderLayout.SOUTH);
    }
}
