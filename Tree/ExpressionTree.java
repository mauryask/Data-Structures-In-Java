// Given post-fix expression print infix and prefix expressions
// Note: The Inorder and Preorder traversal of Postfix expression tree gives
// infix and prefix expressions 

import java.util.*;

class Node {

    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
        left = right = null;
    }
}

public class ExpressionTree {

    static boolean isOperator(char o) {
        if (o == '+' || o == '-' || o == '*' || o == '/' || o == '^' || o == '%') {
            return true;
        }

        return false;
    }

    static Node constructTree(String expression) {
        char[] ch = expression.toCharArray();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            if (!isOperator(ch[i])) {
                stack.push(new Node(ch[i]));
            } else {
                Node node = new Node(ch[i]);
                Node rightChild = stack.pop();
                Node leftChild = stack.pop();

                node.left = leftChild;
                node.right = rightChild;
                stack.push(node);
            }
        }

        return stack.pop();
    }

    //printing infix expression from post-fix expression
    static void infix(Node root) {
        if (root != null) {
            infix(root.left);
            System.out.print(root.value);
            infix(root.right);
        }
    }

    //printing prefix expression using post-fix expression
    static void prefix(Node root) {
        if (root != null) {
            System.out.print(root.value);
            prefix(root.left);
            prefix(root.right);
        }
    }

    public static void main(String[] args) {
        String expression = "67+51*-"; //6+7-5*1 (Infix)
        Node root = constructTree(expression);
        infix(root);
    }
}
