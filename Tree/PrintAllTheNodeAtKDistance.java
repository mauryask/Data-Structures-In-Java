/*
* T(n) : O(n)
 */
import static java.lang.System.*;
import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class PrintAllTheNodeAtKDistance {

    static int count = 0;

    static boolean getPath(Node root, List<Node> list, int k, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            if (count <= k) {
                list.add(root);
                count++;
            }
            return true;
        }

        boolean left = getPath(root.left, list, k, target);

        if (left) {
            if (count <= k) {
                list.add(root);
                count++;
            }
            return true;
        }

        boolean right = getPath(root.right, list, k, target);

        if (right) {
            if (count <= k) {
                list.add(root);
                count++;
            }
            return true;
        }

        return false;
    }

    static void recordDist(Node root, Node blocker, ArrayList<Integer> list, int i, int k) {
        if (root == null || root == blocker) {
            return;
        }

        if (i == k) {
            list.add(root.data);
            return;
        }

        recordDist(root.left, blocker, list, i + 1, k);
        recordDist(root.right, blocker, list, i + 1, k);
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        count = 0;
        List<Node> list = new ArrayList<>();
        getPath(root, list, k, target);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            recordDist(list.get(i), i == 0 ? null : list.get(i - 1), result, i, k);
        }

        Collections.sort(result);

        return result;
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
        Node r16 = new Node(16);
        Node r17 = new Node(17);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r5.left = r8;
        r5.right = r9;
        r6.right = r10;
        r10.left = r13;
        r7.left = r12;
        r7.right = r11;

        KDistanceNodes(root, 5, 2);
    }
}
