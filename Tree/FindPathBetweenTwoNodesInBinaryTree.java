/*
* The idea is to find LCA first 
* then store node to root path in a list
* T(n) : O(n) 
* S(n) : O(n)
*/

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
		left = right = null;
	}
}

public class FindPathBetweenTwoNodesInBinaryTree 
{
	// T(n) : O(n)
	static Node findLCA(Node root, int m, int n)
	{
		if(root == null)
			return null;
		
		if(root.data == m || root.data == n)
			return root;
		
		Node left = findLCA(root.left, m, n);
		Node right = findLCA(root.right, m, n);
		
		if(left != null && right != null)
			return root;
		else 
			return left == null ? right : left;
	}
	
	// T(n) : O(n)
	static boolean nodeToRootPath(Node root, int m, int n, List<Integer> path, boolean bottom2Top)
	{
		if(root == null)
			return false;
		if(root.data == m || root.data == n)
		{
			if(bottom2Top)  
				path.add(root.data); 
			else
				path.add(0, root.data);
			
			return true; 
		}
		
		boolean left = nodeToRootPath(root.left, m, n, path, bottom2Top);
		
		if(left)
		{
			if(bottom2Top)  
				path.add(root.data);
			else
				path.add(0, root.data);
			return true;
		}
		else
		{
			boolean right = nodeToRootPath(root.right, m, n, path, bottom2Top);
			if(right)
			{
				if(bottom2Top)  
					path.add(root.data); 
				else
					path.add(0, root.data);			
				return true;
			}
		}
		
		return false;
	}
	
	static void findPath(Node root, int m, int n)
	{
		if(root == null)
			return;
		
	   	Node lca = findLCA(root, m, n);
		
		List<Integer> leftPath = new ArrayList<>();
		List<Integer> rightPath = new ArrayList<>();
		
        nodeToRootPath(lca.left, m, n,leftPath, true);
		leftPath.add(lca.data);
        nodeToRootPath(lca.right, m, n, rightPath, false);
		
		leftPath.addAll(rightPath);
		
		out.println(leftPath);
	}

		
	public static void main(String [] args)
	{
		  /*Node root = new Node(5);
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
		  r4.right = r7;*/		  
		  
		  Node root = new Node(7);
		  Node r2 = new Node(12);
		  Node r3 = new Node(2);
		  Node r4 = new Node(11);
		  Node r5 = new Node(13);
		  Node r6 = new Node(5);
		  Node r7 = new Node(3);
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

         findPath(root, 3, 1);       
	}
}