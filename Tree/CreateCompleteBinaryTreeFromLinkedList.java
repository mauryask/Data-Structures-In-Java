import java.util.*;

class TreeNode {

    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

class Node {

    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class CreateCompleteBinaryTreeFromLinkedList {

    public TreeNode linkedListToBinaryTree(Node head) {
        if (head == null) {
            return null;
        }

        Queue<TreeNode> q = new ArrayDeque();
        TreeNode root = new TreeNode(head.data);
        q.add(root);
        head = head.next;

        while (!q.isEmpty() && head != null) {
            TreeNode temp = q.poll();

            if (head != null) {
                temp.left = new TreeNode(head.data);
                q.add(temp.left);
                head = head.next;
            }

            if (head != null) {
                temp.right = new TreeNode(head.data);
                q.add(temp.right);
                head = head.next;
            }
        }

        return root;
    }
}
