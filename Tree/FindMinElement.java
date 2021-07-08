/**
Time complexity  : O(n)
Space complexity : O(n) // recursion stack
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

public class FindMinElement
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
		
	static int findMin(Node root)
	{
		if(root == null)
			return Integer.MAX_VALUE;
		
		// find min in left sub tree
		// find min in right sub tree
		// compare both with root element
		// take the smallest of the three
		// smae case applies on finding max element
		
		return Math.min(root.data, Math.min(findMin(root.left),
		findMin(root.right)));
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
		out.println(findMin(root));
		
		}
}