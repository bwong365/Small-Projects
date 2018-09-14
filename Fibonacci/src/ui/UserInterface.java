package ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable{
    private JFrame frame;

    public UserInterface() {

    }


    @Override
    public void run() {
        frame = new JFrame("fibonacci.Fibonacci");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 200));
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JLabel label = new JLabel("Enter 'n'");
        JTextField textField = new JTextField();
        JButton button = new JButton("Calculate");

        button.addActionListener(new FibListener(label, textField));
        container.add(label);
        container.add(textField);
        container.add(button);
    }
}
