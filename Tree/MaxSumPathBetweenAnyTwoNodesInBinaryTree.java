/*
* T(n) : O(n) 
* S(n) : O(n) 
*/

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

public class MaxSumPathBetweenAnyTwoNodesInBinaryTree {
    static int max = Integer.MIN_VALUE;

    static int solve(Node root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);
        //Sum of nodes between left subtree and right subtree 
        int sum = left + right + root.data;
		// Max sum of left or right subtree nodes
        int sum1 = Math.max(left, right) + root.data;
		// Calculate overall max value (Remember you have to include the root node as well in calculating max)
		// As all the paths might be less as compare to root value 
        max = Math.max(root.data, Math.max(max, Math.max(sum, sum1)));
        //Retunrn max from left or right subtree (which ever is max)
        return Math.max(root.data, sum1);
    }

    public int maxPathSum(Node root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }
}
