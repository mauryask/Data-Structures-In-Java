/*
* Time complexity: O(n)
* Space complexity: O(n1) + O(n2) = O(n)
* One level will be pushed in one stack
* another level will be pushed in another stack
* Hence total complexity: O(n)
* Don't need to use "Queue DS" here
**/

import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ZigZagTraversal {

    static ArrayList<Integer> zigZagTraversal(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean l2r = true;
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int count = l2r ? stack1.size() : stack2.size();

            while (count-- > 0) {
                if (l2r) {
                    root = stack1.pop();
                    list.add(root.data);
                    if (root.left != null) {
                        stack2.push(root.left);
                    }

                    if (root.right != null) {
                        stack2.push(root.right);
                    }
                } else if (!l2r) {
                    root = stack2.pop();
                    list.add(root.data);
                    if (root.right != null) {
                        stack1.push(root.right);
                    }

                    if (root.left != null) {
                        stack1.push(root.left);
                    }
                }
            }

            l2r = !l2r;
        }

        return list;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node r2 = new Node(2);
        Node r3 = new Node(3);
        Node r4 = new Node(4);
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        Node r7 = new Node(7);
        Node r8 = new Node(8);
        Node r9 = new Node(9);
        Node r10 = new Node(10);
        Node r11 = new Node(11);
        Node r12 = new Node(12);
        Node r13 = new Node(13);
        Node r14 = new Node(14);
        Node r15 = new Node(15);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.left = r8;
        r4.right = r9;
        r5.left = r10;
        r5.right = r11;
        r6.left = r12;
        r6.right = r13;
        r7.left = r14;
        r7.right = r15;

        ArrayList<Integer> list = zigZagTraversal(root);
		for(int nodeValue : list){
			System.out.print(nodeValue+" ");
		}
    }
}
