package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

public class GUI {
    private JTextArea textArea1;
    private JPanel panel1;
    private JTextField textField1;
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
                    CustomHashMap customHashMap = CustomHashMapUtils.findProperNames(FileUtils.read(fileName[0]));
                    List lst = customHashMap.toList();
                    String txt = "";
                    for (int i = 0; i < lst.size(); i++) {
                        txt += lst.get(i) + "\n";
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
