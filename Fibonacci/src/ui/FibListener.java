package ui;

import fibonacci.Fibonacci;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibListener implements ActionListener {
    private JLabel label;
    private JTextField textField;

    public FibListener(JLabel label, JTextField textField) {
        this.label = label;
        this.textField = textField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(textField.getText());
        label.setText(String.valueOf(Fibonacci.sequence(a)));
    }
}
