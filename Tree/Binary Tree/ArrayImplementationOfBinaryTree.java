
import static java.lang.System.*;
import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class ArrayImplementationOfBinaryTree {
    //Recursive version of creating A BST 
    static Node createBST(int[] A, int index, int n) {
        if (index >= n) {
            return null;
        }

        Node root = new Node(A[index]);

        root.left = createBST(A, 2 * index + 1, n);
        root.right = createBST(A, 2 * index + 2, n);

        return root;
    }

    public static void main(String[] args) {
        int[] A = {10, 12, 45, 78, 96, 52, 10};
        Node root = createBST(A, 0, A.length);
    }
}
