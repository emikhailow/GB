package GB8_Homework;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyApp extends JFrame{

    private MyApp(){

        setTitle("Мое окошко");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        /*
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        for(int i = 1; i < 11; i++){
            add(new JButton(String.valueOf(i)));
        }*/

        /*setLayout(new GridLayout(3, 3));
        for(int i = 1; i < 11; i++){
            add(new JButton(String.valueOf(i)));
        }*/

        setLayout(null);
        final JTextField textField = new JTextField();
        textField.setBounds(20, 20, 100, 40);
        add(textField);
        JButton button = new JButton("Мне повезет");
        button.setBounds(20, 60, 100, 40);
        add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Нажали кнопку");
            }
        });

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Нажали Enter");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Остророжно, окно закрывается");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new MyApp();

    }



}

