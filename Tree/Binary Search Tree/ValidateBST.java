/**
Time complexity  : O(n)
Space complexity : O(height) : stack as extra space
*/

/**
* BST Property : for each node value of nodes in its
* left subtree will be less than the root node value
* and value of each node in the right sub tree 
* will be greater than the value of root node
* If this property is voilated for any node then
* we can say that tree is not BST
*** Inorder traverssal is being used here
*/

import static java.lang.System.*;
import java.util.*;

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

public class ValidateBST
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
	
		static boolean validateBST(Node root)
		{
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
				
				// check BST property
				if(root.left != null && root.left.data > root.data)
					return false;
				if(root.right != null && root.right.data < root.data)
					return false;
				root = root.right;
			}
			return true;
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
		out.println(validateBST(root));
	}
}