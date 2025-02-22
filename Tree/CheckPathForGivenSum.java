
/**
 * Time complexity  : O(n)
 * Space complexity : O(n) : as recursion stack
 */
import java.util.*;
class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class CheckPathForGivenSum {

    //Recursive approach
    boolean hasSumUtil(Node root, int target, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.data;

        boolean left = hasSumUtil(root.left, target, sum);
        if (left) {
            return true;
        }

        boolean right = hasSumUtil(root.right, target, sum);
        if (right) {
            return true;
        }

        if (root.left == null && root.right == null && sum == target) {
            return true;
        }

        sum -= root.data;

        return false;
    }

    // Iterative approach
    //Check if there exists root to leaf path for given sum
    static boolean hasPathSum(Node root, int target) {
        Stack<Node> stack = new Stack<>();
        int sum = 0;
        Node prev = null;

        while (true) {
            while (root != null) {
                stack.push(root);
                sum += root.data;
                root = root.left;
            }

            while (root == null && !stack.isEmpty()) {
                root = stack.peek();

                if (root.right == null || root.right == prev) {
                    if (root.left == null && root.right == null && sum == target) {
                        return true;
                    }

                    sum -= root.data;
                    prev = root;
                    stack.pop();
                    root = null;
                } else {
                    root = root.right;
                }
            }

            if (stack.isEmpty()) {
                break;
            }
        }

        return false;
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

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.left = r8;
        r4.right = r9;
        r5.left = r10;
    }
}
