import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
	   right = left = null;
	}
}

public class FindMaxSumOfSubTreeWhichIsAlsoBST
{
    static int maxSum = 0;
    
    // Bruteforce solution
    // T(n) : O(n*n)
    // S(n) : O(n)
 	
	static int findMaxSum(Node root)
	{
		if(root == null)
			return 0;
		
		int lSum = findMaxSum(root.left);
		int rSum = findMaxSum(root.right);
		int sum = root.data + lSum + rSum;
		
		boolean isBst = checkIfBst(root);
		
		if(isBst)
			maxSum = Math.max(maxSum, sum);
				
		return sum;
	}
	
	static boolean checkIfBst(Node root)
	{
		if(root == null)
			return true;
		
		int prev = Integer.MIN_VALUE;
		
		Stack<Node> stack = new Stack<>();

       while(true)
	   {
		   while(root != null)
		   {
			   stack.push(root);
			   root = root.left;
		   }
		   
		   if(stack.isEmpty())
			   break;
		   
		   root = stack.pop();
		   
		   if(root.data <= prev)
			   return false;
		   
		   prev = root.data;
		   
		   root = root.right;
	   }
	   
      return true;	   
	}
	
	
	// Optimized Solution 
	// T(n): O(n) 
	// S(n) : O(n)
	static boolean isBst = true;
	
	static int getMaxSum(Node root)
	{
		if(root == null)
		{
			isBst = true;
			return 0;
		}
		else if(root.left == null && root.right == null)
		{
			isBst = true;
			return root.data;
		}
		
		int lSum = getMaxSum(root.left);
		int rSum  = getMaxSum(root.right);
		
	    int leftData =  root.left == null ? 0 : root.left.data;
		
		int rightData = root.right == null ? 0 : root.right.data;
		
		isBst =  isBst && lSum != Integer.MIN_VALUE && rSum != Integer.MIN_VALUE && (root.data > leftData && root.data < rightData);
		
		
		if(isBst)
		{
			int sum  = root.data + lSum + rSum;
            maxSum = Math.max(maxSum, sum);
			return sum;
		}
         else
	        return Integer.MIN_VALUE;			 		
	}
    
	public static void main(String[] args)
	{
		 /* Node root = new Node(3);
		  Node r2 = new Node(1);
		  Node r3 = new Node(2);
		  Node r4 = new Node(4);
		  Node r5 = new Node(12);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);*/
		  
		   Node root = new Node(7);
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
		  r6.left = r8;
				  
		  getMaxSum(root);
		  out.println(maxSum);
	}
}
