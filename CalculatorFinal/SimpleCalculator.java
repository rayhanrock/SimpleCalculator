package CalculatorFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends SimpleCalculation {

    public SimpleCalculator() {
        JFrame frame = new JFrame("Buttons");

        Container c = frame.getContentPane();

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());

        mainPane.setLayout(new GridLayout(4, 4, 4, 4));
        final JTextField dispaly = new JTextField(100);
        Font myFontSize = dispaly.getFont().deriveFont(Font.BOLD, 50f);
        dispaly.setFont(myFontSize);
        c.add(dispaly, BorderLayout.NORTH);

        final JButton one = new JButton("1");
        one.setSize(20, 15);

        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = one.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton two = new JButton("2");
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = two.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton three = new JButton("3");
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = three.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton four = new JButton("4");
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = four.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton five = new JButton("5");
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = five.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton six = new JButton("6");
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = six.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton seven = new JButton("7");
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = seven.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton eight = new JButton("8");
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = eight.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton nine = new JButton("9");
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = nine.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton zero = new JButton("0");
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = zero.getText();
                String global = dispaly.getText();

                global = global.concat(num1);
                dispaly.setText(global);

            }

        });

        final JButton addition = new JButton("+");
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = addition.getText();
                String global = dispaly.getText();

                if (global.isEmpty()) {

                    global = null;
                } else if (!(global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/"))) {

                    global = global.concat(num1);

                }
                dispaly.setText(global);

            }

        });

        final JButton subtraction = new JButton("-");
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = subtraction.getText();
                String global = dispaly.getText();
                if (!(global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/"))) {

                    global = global.concat(num1);

                } else if (global.isEmpty()) {
                    global = null;
                }
                dispaly.setText(global);

            }

        });

        final JButton multiplication = new JButton("*");
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = multiplication.getText();
                String global = dispaly.getText();
                if (global.isEmpty()) {

                    global = null;
                } else if (!(global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/"))) {

                    global = global.concat(num1);

                }
                dispaly.setText(global);

            }

        });
        final JButton division = new JButton("/");
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = division.getText();
                String global = dispaly.getText();
                if (global.isEmpty()) {

                    global = null;
                } else if (!(global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/"))) {

                    global = global.concat(num1);

                }
                dispaly.setText(global);

            }

        });

        final JButton equal = new JButton("=");
        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String global = dispaly.getText();

                if (global.startsWith("-")) {
                    global = "0" + global;
                }

                if (global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/") || global.endsWith(".")) {

                    dispaly.setText("Syntax Error !");
                } else if (global.isEmpty()) {
                    //do nothing
                } else {
                    dispaly.setText(calculate(global));
                }

            }

        });

        final JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String global = dispaly.getText();
                global = null;
                dispaly.setText(global);

            }

        });
        final JButton backSpace = new JButton("BackSpace");
        backSpace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String global = dispaly.getText();
                if ((global.length() - 1) >= 0) {
                    global = global.substring(0, (global.length() - 1));
                }

                dispaly.setText(global);

            }

        });
        final JButton decimalPoint = new JButton(".");
        decimalPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = decimalPoint.getText();
                String global = dispaly.getText();
                if (!(global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/"))) {

                    global = global.concat(num1);

                }

                dispaly.setText(global);

            }

        });

        dispaly.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                String global = dispaly.getText();

                if (global.isEmpty()) {
                    if (!(c == '.' || c == '-' || Character.isDigit(c))) {
                        ke.consume();
                    }

                } else {
                    if (global.endsWith(".") || global.endsWith("+") || global.endsWith("-") || global.endsWith("*") || global.endsWith("/")) {
                        if (c == '+' || c == '-' || c == '.' || c == '/' || c == '*') {

                            ke.consume();
                        }

                    }
                }

            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });

        mainPane.add(one);
        mainPane.add(two);
        mainPane.add(three);
        mainPane.add(four);
        mainPane.add(five);
        mainPane.add(six);
        mainPane.add(seven);
        mainPane.add(eight);
        mainPane.add(nine);
        mainPane.add(zero);
        mainPane.add(addition);
        mainPane.add(subtraction);
        mainPane.add(multiplication);
        mainPane.add(division);
        mainPane.add(equal);
        mainPane.add(clear);
        mainPane.add(backSpace);
        mainPane.add(decimalPoint);

        c.add(mainPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 750, 500);
        frame.setTitle("Simple Calculator");
        
        frame.setVisible(true);
    }

}
