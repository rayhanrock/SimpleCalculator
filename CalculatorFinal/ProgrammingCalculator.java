package CalculatorFinal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class ProgrammingCalculator extends JFrame {

    private static final int NUMBER_OF_TYPE = 4;
    private Container container;
    private JTextArea inputTextArea;
    private Font arialBoldFont;
    private JButton convertButton, clearButton;
    private JComboBox typeComboBox;

    private JLabel inputLabel,
            binaryLabel = new JLabel("binary"),
            octalLabel = new JLabel("octal"),
            decimalLabel = new JLabel("decimal"),
            hexadecimalLabel = new JLabel("hexadecimalLabel");

    private JLabel[] listLabel = {
        binaryLabel,
        octalLabel,
        decimalLabel,
        hexadecimalLabel

    };
    private Convertable typeBinary = new Binary(),
            typeOctal = new Octal(),
            typeDecimal = new Decimal(),
            typeHexadecimal = new Hexadecimal();

    private Convertable[] typeListComboBox = {
        typeBinary,
        typeOctal,
        typeDecimal,
        typeHexadecimal
    };

    HashMap<String, JLabel> result = new HashMap<>();

    public ProgrammingCalculator() {
        initComponents();
        frame();
        eventHandler();
    }

    private void frame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Programmin Calculator");
        this.setResizable(false);
        this.setBounds(100, 100, 550, 500);
    }

    private void eventHandler() {

        inputTextArea.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

                AllowedKey selected_type = (AllowedKey) typeComboBox.getSelectedItem();
                selected_type.allowedKey(ke);

            }

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    ke.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {

                int position = inputTextArea.getCaretPosition();
                inputTextArea.setText(inputTextArea.getText().toUpperCase());
                inputTextArea.setCaretPosition(position);

            }

        });

        convertButton.addActionListener((ActionEvent event) -> {
            this.convert();
        });
        
        clearButton.addActionListener((ActionEvent event) -> {
             this.clear();
            
            
        });

    }
    
    private void clear() {
        inputTextArea.setText(null);
        hexadecimalLabel.setText("Hexadecimal : " + 0);
        octalLabel.setText("Octal : " + 0);
        decimalLabel.setText("Decimal : " + 0);
        binaryLabel.setText("Binary : " + 0);

    }

    private void convert() {
        Convertable selected_type = (Convertable) typeComboBox.getSelectedItem();

        String inputText = inputTextArea.getText();

        if (!inputText.isEmpty()) {
            for (int i = 0; i < NUMBER_OF_TYPE; i++) {
                this.result.put(this.listLabel[i].getName(), this.listLabel[i]);
            }
            selected_type.convert(this.result, inputText);

        }
    }

    private void initComponents() {

        arialBoldFont = new Font("arial", Font.BOLD, 15);

        container = this.getContentPane();
        container.setLayout(null);

        inputLabel = new JLabel();
        inputLabel.setText("Input Number System");
        inputLabel.setBounds(145, 20, 300, 30);
        container.add(inputLabel);

        typeComboBox = new JComboBox(typeListComboBox);
        typeComboBox.setBounds(280, 20, 120, 30);
        typeComboBox.setSelectedItem(typeListComboBox[0]);
        container.add(typeComboBox);

        inputTextArea = new JTextArea();
        inputTextArea.setBounds(145, 60, 255, 30);
        inputTextArea.setFont(arialBoldFont);
        inputTextArea.setLineWrap(true);

        container.add(inputTextArea);

        convertButton = new JButton();
        convertButton.setText("Convert");

        convertButton.setBounds(145, 100, 255, 30);
        container.add(convertButton);
        
        clearButton = new JButton();
        clearButton.setText("Clear");

        clearButton.setBounds(145, 135, 255, 30);
        container.add(clearButton);

        decimalLabel.setText("Decimal : " + 0);
        decimalLabel.setName("decimal");
        decimalLabel.setBounds(145, 170, 300, 20);
        container.add(decimalLabel);

        binaryLabel.setText("Binary : " + 0);
        binaryLabel.setName("binary");
        binaryLabel.setBounds(145, 220, 300, 20);
        container.add(binaryLabel);

        octalLabel.setText("Octal : " + 0);
        octalLabel.setName("octal");
        octalLabel.setBounds(145, 195, 300, 20);
        container.add(octalLabel);

        hexadecimalLabel.setText("Hexadecimal : " + 0);
        hexadecimalLabel.setName("hexadecimal");
        hexadecimalLabel.setBounds(145, 245, 300, 20);
        container.add(hexadecimalLabel);

    }

    public static void main(String[] args) {

        new ProgrammingCalculator();

    }
}
