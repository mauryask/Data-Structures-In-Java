import static java.lang.System.*;

// T(n) : O(n)
// S(n) : O(n)

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class CheckIfBinaryTreeIsBalanced {

    static int balanceBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int lHeight = balanceBinaryTree(root.left);
        // Do not make unneccessary calles to right if left substree is not balanced
        if (lHeight == -1) {
            return -1;
        }

        int rHeight = balanceBinaryTree(root.right);

        if (rHeight == -1 || Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        Node r2 = new Node(1);
        Node r3 = new Node(2);
        Node r4 = new Node(4);
        Node r5 = new Node(12);
        Node r6 = new Node(25);
        Node r7 = new Node(10);
        Node r8 = new Node(14);
        Node r9 = new Node(23);
        Node r10 = new Node(52);
        Node r11 = new Node(7);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.right = r8;
        //r8.right = r10;
        r7.left = r9;
        //r9.left = r11;

        out.println(balanceBinaryTree(root) < 0 ? "Not balanaced!!" : "Balanced!!");
    }
}
