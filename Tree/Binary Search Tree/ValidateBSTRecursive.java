/**
Time complexity  : O(n)
Space complexity : O(n) : as recursion stack
*/

import static java.lang.System.*;

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

public class ValidateBSTRecursive
{
	static void inorder(Node root)
	{
		if(root != null)
		{
			inorder(root.left);
			out.print(root.data+" ");
			inorder(root.right);
		}
	}

	static boolean isBST(Node root, int min, int max)
	{
		if(root == null)
			return true;
	
		if(root.data <= min  || root.data >= max) 
			return false;		
		// if both sub tress are BST
		// The recursion follows BST property: everthing in the left subtree shouild be less than and root value and everything in the 
		// right subtree should be greater than the root value
		// for a root in the left substree everything should be less than root: hence update max to root value
		// for a root in the right subtree everthing should be greater than the root: hence update min to root value
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	public static void main(String [] args)
	{
		Node root = null;
		root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		Node r8 = new Node(8);
		Node r9 = new Node(9);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r4.left = r8;
		r7.right = r9;
		
		inorder(root);
		out.println();
		out.println(isBST(root));
	}
}