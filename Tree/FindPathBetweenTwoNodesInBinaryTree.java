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
	static boolean nodeToRootPath(Node root, int d, List<Integer> path, boolean isSource)
	{
		if(root == null)
			return false;
		if(root.data == d)
		{
			if(isSource)  
				path.add(root.data); 
			else
				path.add(0, root.data);
			
			return true; 
		}
		
		boolean left = nodeToRootPath(root.left, d, path, isSource);
		
		if(left)
		{
			if(isSource)  
				path.add(root.data);
			else
				path.add(0, root.data);
			return true;
		}
		else
		{
			boolean right = nodeToRootPath(root.right, d, path,isSource);
			if(right)
			{
				if(isSource)  
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
		
		List<Integer> srcToRootPath = new ArrayList<>();
		List<Integer> rootToDestPath = new ArrayList<>();
		
        nodeToRootPath(lca, m,srcToRootPath, true);		
        nodeToRootPath(lca.right,n, rootToDestPath, false);
		
		srcToRootPath.addAll(rootToDestPath);
		
		out.println(srcToRootPath);
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