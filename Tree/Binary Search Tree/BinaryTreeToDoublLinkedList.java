/**
Time complexity  : O(n)
Space complexity : O(n)
* Inorder traversal based DLL
* There could be BFS (level order traversal) based DLL
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

public class BinaryTreeToDoublLinkedList
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
		
	static Node bstToDll(Node root)
	{
		Node prev = null;
		Node head = null;
		if(root == null)
			return null;
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
			if(head == null)
				head = root;
			
			if(prev != null)
			{
				root.left = prev;
				prev.right = root;
			}
			prev = root;
			root = root.right;
		}
		
		// converting into circular DLL
		// at end prev will be left so
		prev.right = head;
		head.left = prev;

		return head;
	}
	
	static void printList(Node head)
	{
		Node ptr = head;
		do
		{
			out.print(ptr.data+" ");
			ptr = ptr.right;
		}while(ptr != head);
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
		
		inorder(root);
		out.println();	
		Node head = bstToDll(root);
		printList(head);
	}
}