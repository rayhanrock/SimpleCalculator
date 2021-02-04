package CalculatorFinal;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JLabel;

public class Hexadecimal implements Convertable, AllowedKey {

    public int toDecimal(String hexnum) {
        String hstring = "0123456789ABCDEF";
        hexnum = hexnum.toUpperCase();
        int num = 0;
        for (int i = 0; i < hexnum.length(); i++) {
            char ch = hexnum.charAt(i);
            int n = hstring.indexOf(ch);
            num = 16 * num + n;
        }
        return num;
    }

    public String toOctal(String hexnum) {
        int decimal = this.toDecimal(hexnum);
        Decimal object = new Decimal();
        String octal = object.toOctal(decimal);

        return octal;
    }

    public String toBinary(String hexnum) {
        int decimal = this.toDecimal(hexnum);
        Decimal object = new Decimal();
        String binary = object.toBinary(decimal);

        return binary;
    }

    @Override
    public void convert(HashMap<String, JLabel> result, String input) {

        result.get("binary").setText("Binary : " + this.toBinary(input));
        result.get("octal").setText("Octal : " + this.toOctal(input));
        result.get("decimal").setText("Decimal : " + Integer.toString(this.toDecimal(input)));
        result.get("hexadecimal").setText("Hexadecimal : " + input);

    }

    @Override
    public void allowedKey(KeyEvent ke) {
        char c = ke.getKeyChar();
        char c_uppercase = Character.toUpperCase(c);
        int i = 0;
        char[] allowed_char = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F'};
        for (char each : allowed_char) {

            if (each == c_uppercase) {

                ++i;
            }

        }
        if (i == 0) {
            ke.consume();
        }
    }

    @Override
    public String toString() {
        return "Hexadecimal";
    }

}
