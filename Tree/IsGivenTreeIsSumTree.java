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

public class IsGivenTreeIsSumTree
{
    static boolean isSumTree = true;
	
	static int sumTree(Node root)
	{
		if(root == null)
			return 0;
		
		if(!isSumTree)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.data;
		
		int lSum = sumTree(root.left);
		int rSum = sumTree(root.right);
		
		if(lSum + rSum != root.data)
			isSumTree = false;
		
		return root.data + lSum + rSum;
	}
	
	
	// T(n) : O(n*n)
	// S(n) : O(n)
	
	static boolean bruteForce(Node root)
	{
		if(root == null || (root.left == null && root.right == null))
			return true;
		
		int lSum = findSum(root.left);
		int rSum = findSum(root.right);
		int sum = lSum + rSum;
		
		if(sum == root.data && bruteForce(root.left) && bruteForce(root.right))
			return true;
		
		return false;
	}
	
	static int findSum(Node root)
	{
		if(root == null)
			return 0;
        return root.data + findSum(root.left) + findSum(root.right);		
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(3);
		  Node r2 = new Node(1);
		  Node r3 = new Node(2);
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
		  
		  /*sumTree(root);
		  out.println(isSumTree);*/
		  
		  out.println(bruteForce(root));
	}
}
