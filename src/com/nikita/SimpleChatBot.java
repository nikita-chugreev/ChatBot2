package com.nikita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatBot extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "ChatBot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGTH = 450;

    SimpleBot sbot;
    JTextArea dialogue;
    JCheckBox ai;
    JTextField message;
    JButton enter;

    public static void main(String[] args) {
        new SimpleChatBot();
    }

    SimpleChatBot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGTH);
        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(dialogue);
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox("Ai");
        ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        enter = new JButton("Enter");
        enter.addActionListener(this);
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollPane);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM + ": " + sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
