
import java.util.*;
// https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
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
    Node createTree(int index, int n, Map<Integer, Integer> map) {
        if (index >= n) {
            return null;
        }

        Node root = new Node(map.get(index));

        root.left = createTree(2 * index + 1, n, map);
        root.right = createTree(2 * index + 2, n, map);

        return root;
    }

    //Level order traversal more space efficient approach
    public Node linkedListToBinaryTree(Node head) {
        if (head == null) {
            return null;
        }

        Queue<Node> q = new ArrayDeque();
        Node root = new Node(head.data);
        q.add(root);
        head = head.next;

        while (!q.isEmpty() && head != null) {
            Node temp = q.poll();

            if (head != null) {
                temp.left = new Node(head.data);
                q.add(temp.left);
                head = head.next;
            }

            if (head != null) {
                temp.right = new Node(head.data);
                q.add(temp.right);
                head = head.next;
            }
        }

        return root;
    }
}
