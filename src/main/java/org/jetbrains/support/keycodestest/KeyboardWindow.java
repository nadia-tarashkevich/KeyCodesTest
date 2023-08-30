package org.jetbrains.support.keycodestest;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardWindow {
    private JPanel contentPanel;
    private JTextField inputField;
    private JScrollPane outputPane;
    private JTextPane outputField;
    private JButton clearButton;
    private JButton copyButton;
    //private JScrollPane outputPane;

    KeyboardWindow() {
        /*Toolkit.getDefaultToolkit().addAWTEventListener(
        event -> System.out.println("AWTEventListener: " + event),
        KeyEvent.KEY_EVENT_MASK
        );*/

        copyButton.addActionListener(e -> {
            outputField.selectAll();
            StringSelection stringSelection = new StringSelection(outputField.getSelectedText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });

        clearButton.addActionListener(e -> outputField.setText(""));


        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n\n" );
            }

            @Override
            public void keyPressed(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n\n");
            }
        });
    }

    public JPanel getContent(){

        return contentPanel;
    }

}