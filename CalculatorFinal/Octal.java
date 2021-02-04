package CalculatorFinal;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JLabel;

public class Octal implements Convertable, AllowedKey {

    public int toDecimal(int onum) {

        int num = 0;

        int p = 0;
        while (true) {
            if (onum == 0) {
                break;
            } else {
                int temp = onum % 10;
                num += temp * Math.pow(8, p);
                onum = onum / 10;
                p++;
            }
        }
        return num;
    }

    public String toHexadecimal(int oct) {
        int dec = 0, i = 0, rem;
        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hexdec = "";

        while (oct != 0) {
            dec = dec + (oct % 10) * (int) Math.pow(8, i);
            i++;
            oct = oct / 10;
        }
        while (dec != 0) {
            rem = dec % 16;
            hexdec = a[rem] + hexdec;
            dec = dec / 16;
        }
        return hexdec;
    }

    public String toBinary(int onum) {
        int decimal = this.toDecimal(onum);
        Decimal object = new Decimal();
        String binary = object.toBinary(decimal);
        return binary;
    }

    @Override
    public void convert(HashMap<String, JLabel> result, String input) {

        result.get("binary").setText("Binary : " + this.toBinary(Integer.parseInt(input)));
        result.get("octal").setText("Octal : " + input);
        result.get("decimal").setText("Decimal : " + Integer.toString(this.toDecimal(Integer.parseInt(input))));
        result.get("hexadecimal").setText("Hexadecimal : " + this.toHexadecimal(Integer.parseInt(input)));

    }

    @Override
    public void allowedKey(KeyEvent ke) {
        char c = ke.getKeyChar();
        int i = 0;
        char[] allowed_char = {'0', '1', '2', '3', '4', '5', '6', '7'};
        for (char each : allowed_char) {
            if ((each == c)) {
                ++i;
            }
        }
        if (i == 0) {
            ke.consume();
        }
    }

    @Override
    public String toString() {
        return "Octal";
    }

}
