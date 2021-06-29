/**
Time complexity  : O(log n)
Space complexity : O(Tree height) // as recursion stack
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

public class SearchNodeInBSTRecursive
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
	
	static boolean serachElement(Node root, int value)
	{
		if(root == null)
			return false;
		
		else if(root.data > value)
			return serachElement(root.left, value);
		else if(root.data < value)
			return serachElement(root.right, value);
		
		// the only case left is root.data == value
		return true;
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
		out.println(serachElement(root, 78));
	}
}