
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

public class FindMaxSumOfSubTreeWhichIsAlsoBST {

    static int maxSum = 0;

    // Bruteforce solution
    // T(n) : O(n*n)
    // S(n) : O(n)
    static int findMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        int lSum = findMaxSum(root.left);
        int rSum = findMaxSum(root.right);
        int sum = root.data + lSum + rSum;

        boolean isBst = checkIfBst(root);

        if (isBst) {
            maxSum = Math.max(maxSum, sum);
        }

        return sum;
    }

    static boolean checkIfBst(Node root) {
        if (root == null) {
            return true;
        }

        int prev = Integer.MIN_VALUE;

        Stack<Node> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();

            if (root.data <= prev) {
                return false;
            }

            prev = root.data;

            root = root.right;
        }

        return true;
    }

    /*
    * Optimized Solution 
	* T(n): O(n) 
	* S(n) : O(n)
	* The idea is to maintain max, min and currSum
	* for each and every node 
     */
    static class NodeInfo {

        int max;
        int min;
        boolean isBst;
        int currSum;

        NodeInfo(int max, int min, boolean isBst, int currSum) {
            this.max = max;
            this.min = min;
            this.isBst = isBst;
            this.currSum = currSum;
        }

        NodeInfo(){
        }
    }

    static int maxSumSoFar = 0;

    static NodeInfo getMaxSum(Node root) {
        // If root is null, it is already a BST
        if (root == null) {
            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }

        NodeInfo left = getMaxSum(root.left);
        NodeInfo right = getMaxSum(root.right);

        NodeInfo nodeInfo = new NodeInfo();
        int sum = root.data + left.currSum + right.currSum;
        // The last node returned going to hold sum of all the nodes
        nodeInfo.currSum = sum;

        if ((left.isBst && right.isBst) && (root.data < right.min && root.data > left.max)) {
            nodeInfo.max = Math.max(root.data, Math.max(left.max, right.max));
            nodeInfo.min = Math.min(root.data, Math.min(left.min, right.min));
            nodeInfo.isBst = true;
            maxSumSoFar = Math.max(sum, maxSumSoFar);
        } else {
            nodeInfo.isBst = false;
        }

        return nodeInfo;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node r2 = new Node(9);
        Node r3 = new Node(2);
        Node r4 = new Node(6);
        Node r5 = new Node(3);
        Node r6 = new Node(8);
        Node r7 = new Node(7);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r3.right = r5;
        r4.left = r6;
        r4.right = r7;

        /*Node root = new Node(7);
		  Node r2 = new Node(12);
		  Node r3 = new Node(2);
		  Node r4 = new Node(11);
		  Node r5 = new Node(13);
		  Node r6 = new Node(5);
		  Node r7 = new Node(2);
		  Node r8 = new Node(1);
		  Node r9 = new Node(38);
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;		  
		  r3.right = r6;
		  r4.left = r7;
		  r6.right = r9;
		  r6.left = r8;*/
        getMaxSum(root);
        out.println(maxSumSoFar);
    }
}
