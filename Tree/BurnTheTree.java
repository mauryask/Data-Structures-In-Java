/*
* T(n) : O(n*k)
* S(n) : O(n)
 */

import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BurnTheTree {
    static boolean nodeToRootPath(Node root, int value, List<Node> list)
    {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            list.add(root);
            return true;
        }

        boolean left = nodeToRootPath(root.left, value, list);
        if (left) {
            list.add(root);
            return true;
        }

        boolean right = nodeToRootPath(root.right, value, list);
        if (right) {
            list.add(root);
            return true;
        }

        return false;
    }

    static void burn(Node root, Node blocker, int time, Map<Integer, List<Node>> map) 
    {
        if (root == null || root == blocker) {
            return;
        }

        List<Node> list = map.getOrDefault(time, new ArrayList<>());
        list.add(root);
        map.put(time, list);
        //calculate max time here..
        burn(root.left, blocker, time + 1, map);
        burn(root.right, blocker, time + 1, map);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node5.left = node6;
        node6.left = node7;

        List<Node> path = new ArrayList<>();
        nodeToRootPath(root, 6, path);
        
        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < path.size(); i++) {
            burn(path.get(i), i == 0 ? null : path.get(i - 1), i, map);
        }
    }
}
