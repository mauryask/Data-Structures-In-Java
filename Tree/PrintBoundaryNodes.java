
import static java.lang.System.*;
import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class PrintBoundaryNodes {

    static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    static void collectLeftBoundary(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            list.add(root.data);
            collectLeftBoundary(root.left, list);
        } else if (root.right != null) {
            list.add(root.data);
            collectLeftBoundary(root.right, list);
        }
    }

    static void collectLeafNode(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        collectLeafNode(root.left, list);

        if (isLeaf(root)) {
            list.add(root.data);
            return;
        }

        collectLeafNode(root.right, list);
    }

   static void collectRightBoundary(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            collectRightBoundary(root.right, list);
            list.add(root.data);
        } else if (root.left != null) {
            collectRightBoundary(root.left, list);
            list.add(root.data);
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        
		//This is very important condition over here
        if (!isLeaf(root)) {
            list.add(root.data);
        }
        //Collect left bounday
        collectLeftBoundary(root.left, list);
		//Collect leaf nodes
        collectLeafNode(root, list);
		//Collect right boundary
        collectRightBoundary(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        Node r2 = new Node(8);
        Node r3 = new Node(22);
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
        r8.right = r10;
        r7.left = r9;
        r9.left = r11;

        ArrayList<Integer> list = boundaryTraversal(root);
       
	   for(int x : list){
		  out.print(x + " ");
	   }
    }
}
