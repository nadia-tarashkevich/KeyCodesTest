package org.jetbrains.support.keycodestest;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;


public class KeyboardWindow {
    private JPanel contentPanel;
    private JTextField inputField;
    private JEditorPane outputField;
    private JButton copyButton;

    KeyboardWindow(ToolWindow toolWindow) {
        /*Toolkit.getDefaultToolkit().addAWTEventListener(
        event -> System.out.println("AWTEventListener: " + event),
        KeyEvent.KEY_EVENT_MASK
        );*/

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputField.selectAll();
                StringSelection stringSelection = new StringSelection(outputField.getSelectedText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });


        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n" );
            }

            @Override
            public void keyPressed(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                outputField.setText(outputField.getText() + e.toString() + "\n");
            }
        });
    }

    public JPanel getContent(){

        return contentPanel;
    }

}