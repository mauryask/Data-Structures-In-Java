
/**
 * Time complexity  : O(n)
 * Space complexity : O(n)
 ** Here are printing root to leaf
 ** paths
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

public class PrintAllKSumPaths {

    static void kSumPath(Node root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }

        list.add(root.data);
        countPath(list, k);

        kSumPath(root.left, list, k);
        kSumPath(root.right, list, k);

        list.remove(list.size() - 1);
    }

     //Count the number of paths
    static void countPath(List<Integer> list, int k) {
        int sum = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == k) {
                count++;
                printPath(i, list);
            }
        }
    }
     
	//Print the path here
    static void printPath(int startIndex, List<Integer> list) {
        for (int i = startIndex; i < list.size(); i++) {
            out.print(list.get(i) + " ");
        }
		out.println();
    }

    static int count = 0;

    static int sumK(Node root, int k) {
        count = 0;
        kSumPath(root, new ArrayList<>(), k);
        return count;
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
        r4.right = r8;
 
        sumK(root, 7);
    }
}
