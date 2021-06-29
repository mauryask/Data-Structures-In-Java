/**
Time complexity  : O(n)
Space complexity : O(n)
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

// DLL head and tail
// because we want to persist head and tail
// between diferent function calls
class List 
{
	Node listHead = null;
    Node prev = null;
}

public class BinaryTreeToDLLRecursive
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
		
	static void bstToDLL(Node root, List list)
	{
		if(root == null)
			return;	
			
		bstToDLL(root.left,list);
		
		if(list.listHead == null)
		  list.listHead = root;
		
		if(list.prev!= null)
		{
			list.prev.right = root;
			root.left = list.prev;
		}
		list.prev = root;
		bstToDLL(root.right,list);
	}
	
	static void printList(Node head)
	{
		while(head != null)
		{
			out.print(head.data+" ");
			head  = head.right;
		}
		out.println();
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
		insertNode(79);
		insertNode(44);
		insertNode(48);
		insertNode(80);
		
		List list = new List();
		inorder(root);
		out.println();
		bstToDLL(root,list);
		printList(list.listHead);
	}
}