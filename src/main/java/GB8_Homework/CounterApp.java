package GB8_Homework;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    public static final String VALIDATION_MESSAGE_TRUE = "Все хорошо!";
    public static final String VALIDATION_MESSAGE_FALSE = "Число 1 не должно быть меньше числа 2";
    private int value1;
    private int value2;

    CounterApp(int initialValue) {

        setBounds(300, 300, 1000, 150);
        setTitle("My simple counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 100;

        Font font = new Font("Arial", Font.BOLD, 45);

        JButton decrementButton1 = new JButton("<");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;

        decrementButton1.setFont(font);
        add(decrementButton1, c);

        final JLabel label1 = new JLabel();
        label1.setFont(font);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        value1 = initialValue;
        label1.setText(String.valueOf(value1));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        add(label1, c);

        JButton incrementButton1 = new JButton(">");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        incrementButton1.setFont(font);
        add(incrementButton1, c);

        JButton decrementButton2 = new JButton("<");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        decrementButton2.setFont(font);
        add(decrementButton2, c);

        final JLabel label2 = new JLabel();
        label2.setFont(font);
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        value2 = initialValue;
        label2.setText(String.valueOf(value2));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        add(label2, c);

        JButton incrementButton2 = new JButton(">");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 0.5;
        incrementButton2.setFont(font);
        add(incrementButton2, c);

        Font errorFont = new Font("Arial", Font.BOLD, 25);
        final JLabel errorLabel = new JLabel();
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setText(getValidationMessage(value1, value2));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        c.gridwidth = 3;
        add(errorLabel, c);

        incrementButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                value1++;
                label1.setText(String.valueOf(value1));
                errorLabel.setText(getValidationMessage(value1, value2));

            }


        });

        incrementButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                value2++;
                label2.setText(String.valueOf(value2));
                errorLabel.setText(getValidationMessage(value1, value2));

            }
        });

        decrementButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                value1--;
                label1.setText(String.valueOf(value1));
                errorLabel.setText(getValidationMessage(value1, value2));
            }
        });

        decrementButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                value2--;
                label2.setText(String.valueOf(value2));
                errorLabel.setText(getValidationMessage(value1, value2));
            }
        });

        pack();

        setVisible(true);

    }

    public static void main(String[] args) {
        new CounterApp(1);
    }

    private String getValidationMessage(int value1, int value2) {

        return value1 >= value2 ? VALIDATION_MESSAGE_TRUE : VALIDATION_MESSAGE_FALSE;

    }


}
