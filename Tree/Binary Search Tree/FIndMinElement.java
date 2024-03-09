/**
Time complexity  : O(log n)
Space complexity : O(1)
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

public class FIndMinElement
{
	static Node root = null;
	
	static void insertNode(int data)
	{
		Node temp = new Node(data);
		Node currentNode = null, parentNode = null;
		
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode!= null)
			{
				parentNode = currentNode;
				if(currentNode.data < temp.data)
					currentNode = currentNode.right;
				else if(currentNode.data > temp.data)
					currentNode = currentNode.left;
			}
			
			if(parentNode.data > temp.data)
				parentNode.left = temp;
			else if(parentNode.data < temp.data)
				parentNode.right = temp;
		}
	}
	
	static void inorder(Node root)
	{
		if(root != null)
		{
			inorder(root.left);
			out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	// S(n) = O(1) 
	static int findMinElement(Node root)
	{
		if(root == null)
			return null;
		
		while(root.left != null)
			root = root.left;
		
		return root.data;
	}
	
	// S(n) = O(n) : recursion stack
	static Node findMinRecursive(Node root)
	{
		if(root == null)
			return null;
		
		if(root.left == null)
			return root;

		return findMinRecursive(root.left);
	}
	
	public static void main(String [] args)
	{
		insertNode(89);
		insertNode(36);
		insertNode(78);
		insertNode(120);
		insertNode(100);
		insertNode(45);
		insertNode(145);
		
		inorder(root);
		out.println();
		out.println(findMinElement(root));
		out.println(findMinRecursive(root).data);
		
		}
}