package CalculatorFinal;

import java.util.Stack;

public class SimpleCalculation {

    static String calculate(String equation) {
        Stack<String> stack = new Stack<>();

        String sum = "";
        for (int i = 0; i < equation.length(); i++) {

            int number = Character.getNumericValue(equation.charAt(i));

            switch (equation.charAt(i)) {
                case '+':
                    stack.push(sum);
                    sum = "";
                    stack.push("+");
                    break;
                case '-':
                    stack.push(sum);
                    sum = "";
                    stack.push("-");
                    break;
                case '*':
                    stack.push(sum);
                    sum = "";
                    stack.push("*");
                    break;
                case '/':
                    stack.push(sum);
                    sum = "";
                    stack.push("/");
                    break;
                default:
                    if (number == -1) {
                        sum += ".";
                    } else {
                        sum += number;
                    }

                    break;
            }
            if (i == equation.length() - 1) {
                stack.push(sum);
            }
        }

        while (stack.contains("*") || stack.contains("/")) {
            for (int i = 0; i < stack.size(); i++) {

                if ("*".equals(stack.elementAt(i))) {

                    try {
                        float prev = Float.parseFloat(stack.elementAt(i - 1));
                        float next = Float.parseFloat(stack.elementAt(i + 1));
                        float result = prev * next;
                        stack.removeElementAt(i + 1);

                        stack.setElementAt(Float.toString(result), i);
                        stack.removeElementAt(i - 1);
                    } catch (NumberFormatException e) {
                        return "Syntax Error !";
                    }

                } else if ("/".equals(stack.elementAt(i))) {

                    try {
                        float prev = Float.parseFloat(stack.elementAt(i - 1));
                        float next = Float.parseFloat(stack.elementAt(i + 1));
                        float result = prev / next;
                        stack.removeElementAt(i + 1);

                        stack.setElementAt(Float.toString(result), i);
                        stack.removeElementAt(i - 1);
                    } catch (NumberFormatException e) {
                        return "Syntax Error !";
                    }

                }

            }

        }

        while (stack.contains("+") || stack.contains("-")) {
            for (int i = 0; i < stack.size(); i++) {

                if ("+".equals(stack.elementAt(i))) {

                    try {
                        float prev = Float.parseFloat(stack.elementAt(i - 1));
                        float next = Float.parseFloat(stack.elementAt(i + 1));
                        float result = prev + next;
                        stack.removeElementAt(i + 1);

                        stack.setElementAt(Float.toString(result), i);
                        stack.removeElementAt(i - 1);
                    } catch (NumberFormatException e) {
                        return "Syntax Error !";
                    }

                } else if ("-".equals(stack.elementAt(i))) {
                    try {
                        float prev = Float.parseFloat(stack.elementAt(i - 1));
                        float next = Float.parseFloat(stack.elementAt(i + 1));
                        float result = prev - next;
                        stack.removeElementAt(i + 1);

                        stack.setElementAt(Float.toString(result), i);
                        stack.removeElementAt(i - 1);
                    } catch (NumberFormatException e) {
                        return "Syntax Error !";
                    }

                }

            }

        }

        return stack.firstElement();
    }

}
