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

public class FindKthSmallestElement
{
	static Node root = null, head = null, prev = null;
	
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
		
	static void findKthSmallest(Node root, int k)
	{
		Stack<Node> stack = new Stack<>();
		int count = 0;
		int myNode = 0;
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			
			if(count == k)
			{
				out.println(myNode);
				return;
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			count++;
			myNode = root.data;
			root = root.right;
		}
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
		
		findKthSmallest(root, count, 5);
	}
}