/*
* T(n) : O(n) 
* S(n) : O(n) 
 */
public class MaxSumPathBetweenTwoLeafNodesInBinaryTree {

    static int maxSum = Integer.MIN_VALUE;

    int findMaxLeafSum(Node root) {
        if (root == null) {
            return 0;
        }

        // If it is lead node return data directly
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = findMaxLeafSum(root.left);
        int rightSum = findMaxLeafSum(root.right);
        
        // If a non leaf node encountered with left and rigth subtrees as non null
		// Get the max sum between leaf nodes
        if (root.left != null && root.right != null) {
            maxSum = Math.max(maxSum, leftSum + rightSum + root.data);
            return Math.max(leftSum, rightSum) + root.data;
        }
       
	    // If left subtree is not there return max right sum
        if (root.left == null) {
            return rightSum + root.data;
        } else { //Else return max left sum
            return leftSum + root.data;
        }
    }

    int maxPathSum(Node root) {		
        maxSum = Integer.MIN_VALUE;
        findMaxLeafSum(root);
        return maxSum;
    }
}
