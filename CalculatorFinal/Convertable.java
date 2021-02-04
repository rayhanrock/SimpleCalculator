/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculatorFinal;

import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public interface Convertable {

    void convert(HashMap<String, JLabel> result, String input);
}
