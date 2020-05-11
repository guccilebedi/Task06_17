package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class GUI {
    private JPanel panel1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton openFileButton;
    private JButton findProperNamesButton;

    public GUI() {
        final String[] fileName = new String[1];

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName[0] = textField1.getText() + ".txt";
            }
        });

        findProperNamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HashMap simpleHashMap = SimpleHashMapUtils.findProperNames(FileUtils.read(fileName[0]));
                    String txt = null;
                    for (int i = 0; i < simpleHashMap.size(); i++) {
                        if (txt == null) {
                            txt = String.valueOf(simpleHashMap.get(i));
                        } else {
                            txt += "\n" + simpleHashMap.get(i);
                        }
                    }
                    textArea1.setText(txt);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane((new GUI().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
