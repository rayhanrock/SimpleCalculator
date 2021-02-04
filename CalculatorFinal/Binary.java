package CalculatorFinal;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JLabel;

public class Binary implements Convertable, AllowedKey {

    long toOctal(String binarynum) {
        long octalNumber = 0, decimalNumber = 0, i = 0;
        long binary = Long.parseLong(binarynum);
        while (binary != 0) {
            decimalNumber += (binary % 10) * Math.pow(2, i);
            ++i;
            binary /= 10;
        }

        i = 1;

        while (decimalNumber != 0) {
            octalNumber += (decimalNumber % 8) * i;
            decimalNumber /= 8;
            i *= 10;
        }

        return octalNumber;
    }

    public String toHexadecimal(String number) {
        String hexa = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F'};
        if (number != null && !number.isEmpty()) {
            int decimal = toDecimal(number);
            while (decimal > 0) {
                hexa = hex[decimal % 16] + hexa;
                decimal /= 16;
            }

        }
        return hexa;
    }

    public int toDecimal(String number) {
        int length = number.length() - 1;
        int decimal = 0;
        if (isBinary(number)) {
            char[] digits = number.toCharArray();
            for (char digit : digits) {
                if (String.valueOf(digit).equals("1")) {
                    decimal += Math.pow(2, length);
                }
                --length;
            }

        }
        return decimal;
    }

    public boolean isBinary(String number) {
        boolean isBinary = false;
        if (number != null && !number.isEmpty()) {
            Long parsedLong = Long.parseLong(number);
            long num = parsedLong;
            while (num > 0) {
                if (num % 10 <= 1) {
                    isBinary = true;
                } else {
                    isBinary = false;
                    break;
                }
                num /= 10;
            }
        }
        return isBinary;
    }

    @Override
    public void convert(HashMap<String, JLabel> result, String input) {

        result.get("binary").setText("Binary : " + input);
        result.get("octal").setText("Octal : " + Long.toString(this.toOctal(input)));
        result.get("decimal").setText("Decimal : " + Integer.toString(this.toDecimal(input)));
        result.get("hexadecimal").setText("Hexadecimal : " + this.toHexadecimal(input));

    }

    @Override
    public void allowedKey(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (!((c == KeyEvent.VK_0) || (c == KeyEvent.VK_1))) {
            ke.consume();
        }

    }

    @Override
    public String toString() {
        return "Binary";
    }

}
