package CalculatorFinal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class AgeCalculator extends JFrame {

    private Container container;
    private JTextField tfdate, tfmonth, tfyear;
    private JLabel input, year, month, date, header,error, emptyfield;
    private Font arial_bold, errorfont;
    private JButton calculateAge;
    private JPanel ansPane;

    public AgeCalculator() {
        initComponent();
        frame();
    }

    void initComponent() {
        arial_bold = new Font("arial", Font.BOLD, 15);
        errorfont = new Font("arial", Font.ITALIC, 15);

        container = this.getContentPane();
        container.setLayout(null);

        input = new JLabel();
        input.setText("Enter Your Birth Date (DD MM YYYY) : ");
        input.setBounds(100, 20, 210, 30);

        container.add(input);

        tfdate = new JTextField();
        tfdate.setBounds(330, 20, 60, 30);
        tfdate.setFont(arial_bold);

        container.add(tfdate);

        tfmonth = new JTextField();
        tfmonth.setBounds(400, 20, 60, 30);
        tfmonth.setFont(arial_bold);

        container.add(tfmonth);

        tfyear = new JTextField();
        tfyear.setBounds(470, 20, 60, 30);
        tfyear.setFont(arial_bold);

        container.add(tfyear);

        calculateAge = new JButton("Calculate");
        calculateAge.setBounds(550, 20, 100, 30);
        container.add(calculateAge);

        error = new JLabel("Error ! please input a valid date.");
        error.setFont(errorfont);
        error.setVisible(false);
        error.setBounds(330, 50, 300, 30);
        container.add(error);

        emptyfield = new JLabel("Please input you birthdate.");
        emptyfield.setFont(errorfont);
        emptyfield.setVisible(false);
        emptyfield.setBounds(330, 50, 300, 30);
        container.add(emptyfield);

        ansPane = new JPanel();
        ansPane.setBounds(100, 100, 550, 200);
        ansPane.setLayout(null);
        ansPane.setBackground(Color.LIGHT_GRAY);

        container.add(ansPane);



        header = new JLabel("Your Age : ");
        header.setBounds(30, 20, 150, 20);
        header.setFont(arial_bold);
        ansPane.add(header);

        year = new JLabel("Years       :    ..");
        year.setBounds(100, 60, 150, 15);
        ansPane.add(year);

        month = new JLabel("Months   :    ..");
        month.setBounds(100, 80, 150, 15);
        ansPane.add(month);

        date = new JLabel("Days    :    ..");
        date.setBounds(100, 100, 150, 15);
        ansPane.add(date);


        calculateAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgeCalculation object = new AgeCalculation();
                int udate, umonth, uyear;

                if (tfyear.getText().isEmpty() || tfdate.getText().isEmpty() || tfmonth.getText().isEmpty()) {
                    error.setVisible(false);
                    emptyfield.setVisible(true);
                } else {
                    udate = Integer.parseInt(tfdate.getText());
                    umonth = Integer.parseInt(tfmonth.getText());
                    uyear = Integer.parseInt(tfyear.getText());

                    String age = object.calculate(udate, umonth, uyear);
                    if ("0".equals(age)) {
                        emptyfield.setVisible(false);
                        error.setVisible(true);
                    } else {
                        emptyfield.setVisible(false);
                        error.setVisible(false);
                        String[] output = age.split(",", 5);
                        year.setText("Years       :    " + output[2]);
                        month.setText("Months   :    " + output[1]);
                        date.setText("Days    :    " + output[0]);
                    }
                }

            }
        });

        tfdate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char getDate = ke.getKeyChar();

                if (!(Character.isDigit(getDate))) {
                    ke.consume();

                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

        });

        tfyear.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

                char getyear = ke.getKeyChar();

                if (!(Character.isDigit(getyear))) {
                    ke.consume();

                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

        });

        tfmonth.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

                char getmonth = ke.getKeyChar();

                if (!Character.isDigit(getmonth)) {
                    ke.consume();

                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

        });

    }

    public void frame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Age Calculator");
        this.setBounds(100, 100, 750, 500);
    }


}
