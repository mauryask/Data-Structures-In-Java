/**
Time complexity  : O(n)
Space complexity : O(n) 
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

public class CheckIfTwoTreesAreMirror
{	
    static void levelOrder(Node root)
	{
		if(root == null)
			return;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			out.print(root.data+" ");
			
			if(root.left != null)
				q.add(root.left);
			if(root.right != null)
				q.add(root.right);
		}
		out.println();
	}

    static boolean isMirror(Node root1, Node root2)
	{
		// base case
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		Queue<Node> q1 = new ArrayDeque<>();
		Queue<Node> q2 = new ArrayDeque<>();
		
		q1.add(root1);
		q2.add(root2);
		
		while(!q1.isEmpty() && !q2.isEmpty())
		{
			root1 = q1.remove();
			root2 = q2.remove();
			
			if(root1.data != root2.data)
				return false;
			
			if(root1.left != null && root2.right != null)
			{
				q1.add(root1.left);
				q2.add(root2.right);
			}
			else if(root1.left != null || root2.right != null)
				return false;
			
			if(root1.right != null && root2.left != null)
			{
				q1.add(root1.right);
				q2.add(root2.left);
			}
			else if(root1.right != null || root2.left != null)
				return false;
		}
		
		return true;
	}
	
	
	static boolean isMirrorRecursive(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data != root2.data)
			return true;
		
		return isMirrorRecursive(root1.left, root2.right) &&
		isMirrorRecursive(root1.right, root2.left);
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
		
		
		Node rootx = new Node(1);
		Node r2x = new Node(2);
		Node r3x = new Node(3);
		Node r4x = new Node(4);
		Node r5x = new Node(5);
		Node r6x = new Node(6);
		Node r7x = new Node(7);
		Node r8x = new Node(8);
		Node r9x = new Node(9);
		Node r10x = new Node(10);		
		
		rootx.left = r3x;
		rootx.right = r2x;
		r2x.left = r5x;
		r2x.right = r4x;
		r3x.left = r7x;
		r3x.right = r6x;
		r4x.left = r9x;
		r4x.right = r8x;
		r5x.right = r10x;
		
		
		out.println(isMirror(root, rootx));
	}
}