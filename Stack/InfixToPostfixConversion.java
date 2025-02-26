
import java.util.*;

public class InfixToPostfixConversion {
    static int getOperatorPrecedence(char operator) {
        switch (operator) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/', '%' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }

        return -1;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && (getOperatorPrecedence(ch) <= getOperatorPrecedence(stack.peek()))) {
                    sb.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(infixExpression));
    }
}
