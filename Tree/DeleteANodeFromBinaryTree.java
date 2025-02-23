
/**
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */

import static java.lang.System.*;
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

public class DeleteANodeFromBinaryTree {

    static void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.remove();
            out.print(root.data + " ");
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
        }
        out.println();
    }

    static Node deleteNode(Node root, int key) {
        // If root is nul: return null
        if (root == null) {
            return null;
        }

        // If theere is only one node and it is the target node
        if (root.left == null && root.right == null && root.data == key) {
            return null;
        }
        
		//Save the origianl node if the tree
        Node temp = root;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        Node prev = null;
        Node requiredNode = null;

        while (!q.isEmpty()) {
            root = q.poll();

            if (root.data == key) {
                requiredNode = root;
            }

            if (root.left != null) {
                prev = root;
                q.add(root.left);
            }

            if (root.right != null) {
                prev = root;
                q.add(root.right);
            }
        }

        //Return original tree if given node is not found (Means the gievn node already deleted)
        if (requiredNode == null) {
            return temp;
        }

        requiredNode.data = root.data;

        //At the end the root will become the last node (deepes node)
        if (prev.left == root) {
            prev.left = null;
        } else {
            prev.right = null;
        }

        return temp;
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

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
		r7.left = r8;

        levelOrder(root);
        root = deleteNode(root, 8);
        levelOrder(root);
    }
}
