package CalculatorFinal;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JLabel;

public class Decimal implements Convertable, AllowedKey {

    public String toHexadecimal(int decimal) {
        int rem;
        String hex = "";
        char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            rem = decimal % 16;
            hex = hexchars[rem] + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    public String toBinary(int decimal) {
        int a;
        String binary = "";

        while (decimal > 0) {
            a = decimal % 2;
            binary = a + "" + binary;
            decimal = decimal / 2;
        }
        return binary;
    }

    public String toOctal(int decimal) {

        int rem;
        String octal = "";

        char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7'};

        while (decimal > 0) {
            rem = decimal % 8;
            octal = dig[rem] + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    @Override
    public void convert(HashMap<String, JLabel> result, String input) {

        result.get("binary").setText("Binary : " + this.toBinary(Integer.parseInt(input)));
        result.get("octal").setText("Octal : " + this.toOctal(Integer.parseInt(input)));
        result.get("decimal").setText("Decimal : " + input);
        result.get("hexadecimal").setText("Hexadecimal : " + this.toHexadecimal(Integer.parseInt(input)));

    }

    @Override
    public void allowedKey(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (!(Character.isDigit(c))) {
            ke.consume();
        }
    }

    @Override
    public String toString() {
        return "Decimal";
    }

}
