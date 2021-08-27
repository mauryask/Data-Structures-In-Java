/*
* Time complexity: O(n)
* Space complexity: O(n) + O(n) = O(n)
**/

import java.util.*;
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

public class CheckIfTwoBSTAreSame
{
	static Node insertNode(Node root, int data)
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
		
		return root;
	}
	
	static boolean isIdentical(Node root1, Node root2)
	{
		// base case
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		while(true)
		{
			while(root1 != null || root2 != null)
			{
				if(root1 != null)
				{
					 s1.push(root1);
					 root1 = root1.left;
				}
				
			    if(root2 != null)
				{
					s2.push(root2);
					root2 = root2.left;
				}
			}
			
			if(s1.isEmpty() || s2.isEmpty())
				break;
			
			root1 = s1.pop();
			root2 = s2.pop();
			
			if(root1.data != root2.data)
				return false;
			
			root1 = root1.right;
			root2 = root2.right;
		}
		
		if(s1.isEmpty() && s2.isEmpty())
			return true;
		return false;
	}
	
	   public static void main(String [] args)
		{
		
		  Node root1 = null;
		  root1 = insertNode(root1, 89);
		  insertNode(root1, 36);
		  insertNode(root1, 78);
		  insertNode(root1, 120);
		  insertNode(root1, 79);
		  insertNode(root1, 45);
		  insertNode(root1, 44);
		  insertNode(root1, 48);
		  insertNode(root1, 100);
		  insertNode(root1, 145);
		  insertNode(root1, 80);
			  
		  Node root2 = null;
		  root2 = insertNode(root2, 89);
		  insertNode(root2, 36);
		  insertNode(root2, 78);
		  insertNode(root2, 120);
		  insertNode(root2, 79);
		  insertNode(root2, 45);
		  insertNode(root2, 44);
		  insertNode(root2, 48);
		  insertNode(root2, 100);
		  insertNode(root2, 145);
		  insertNode(root2, 80);
		  
		  out.println(isIdentical(root1, root2));
		}
}
