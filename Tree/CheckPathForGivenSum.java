/**
Time complexity  : O(n)
Space complexity : O(n) : as recursion stack
*/

import java.util.*;
import static java.lang.System.*;

class Node 
{
	int data;
	Node left, right;
	
	Node(int data)
	{
		this.data = data;
	}
}

class PathSum
{
	int sum = 0;
	// Is path with required sum exists
	boolean isExisists = false; 
	// path stack
	Stack<Node> path =  new Stack<>();
}

public class CheckPathForGivenSum
{	
	static void checkPathSum(Node root, PathSum p, int target)
	{
		if(root == null)
			return;
		
		p.sum += root.data;
		p.path.push(root);
		
		checkPathSum(root.left, p, target);
		
		if(root.left == null && root.right == null)
		{
			if(p.sum == target)
				p.isExisists = true;
		}
		
		// this part of the code prevents 
		// unneccessary function calls
		// after path with required sum is found
		
		if(!p.isExisists) // call if only if path not found
			checkPathSum(root.right, p, target);
		else
			return;
		
		p.sum -= root.data;
		p.path.pop();
		
	}
	
	public static void main(String [] args)
	{
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r4.left = r8;
		r4.right = r9;
		r5.left = r10;
		
	   PathSum p = new PathSum();
	   checkPathSum(root, p,18);
	   out.println(p.isExisists);
	}
}