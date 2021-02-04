package CalculatorFinal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Home extends JFrame {

    private JButton programmingCalculator, simpleCalculator, ageCalculator;
    private Container container;

    public Home() {
        initComponent();
        frame();

    }

    public void initComponent() {

        container = this.getContentPane();
        container.setLayout(null);
        programmingCalculator = new JButton();

        programmingCalculator = new JButton();
        programmingCalculator.setText("Programming Calculator");
        programmingCalculator.setBounds(265, 30, 200, 50);
        container.add(programmingCalculator);

        simpleCalculator = new JButton();
        simpleCalculator.setText("Simple Calculator");
        simpleCalculator.setBounds(265, 100, 200, 50);
        container.add(simpleCalculator);

        ageCalculator = new JButton();
        ageCalculator.setText("Age Calculator");
        ageCalculator.setBounds(265, 170, 200, 50);
        container.add(ageCalculator);

        programmingCalculator.addActionListener((ActionEvent e) -> {
            new ProgrammingCalculator();
        });

        simpleCalculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SimpleCalculator();

            }
        });

        ageCalculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 new AgeCalculator();

            }
        });

    }

    public void frame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setBounds(100, 100, 750, 500);
    }

    public static void main(String[] args) {
        new Home();
    }

}
