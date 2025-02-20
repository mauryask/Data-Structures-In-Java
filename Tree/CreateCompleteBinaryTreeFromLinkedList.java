
import java.util.*;
// https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/

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
    //Recursive less space efficient approach
    TreeNode createTree(int index, int n, Map<Integer, Integer> map) {
        if (index >= n) {
            return null;
        }

        TreeNode root = new TreeNode(map.get(index));

        root.left = createTree(2 * index + 1, n, map);
        root.right = createTree(2 * index + 2, n, map);

        return root;
    }

    //Level order traversal more space efficient approach
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
