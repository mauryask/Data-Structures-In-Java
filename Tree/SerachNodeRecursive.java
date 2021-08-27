/*
* Time complexity: O(n)
* Spaxce complexity : O(n)
* Issue with this solution is : even if node
* is found it is going to search in other subtrees
* hich is an overhead for us
* time complexity can improved by restricting it
* stop search once the node is found
* see the best recursive implementation 
**/

import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class SerachNodeRecursive
{
	static Node root = null;
	
	static Node insertNode(int data)
	{
		Node parentNode = null, currentNode = null;
		Node temp = new Node(data);
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode != null)
			{
				parentNode = currentNode;
				if(temp.data < currentNode.data)
					currentNode = currentNode.left;
				else
					currentNode = currentNode.right;
			}

			if(temp.data < parentNode.data)
				parentNode.left = temp;
			else
				parentNode.right = temp;
		}

		return temp;
	}	
	
	
	static boolean search(Node root, int target)
	{
		if(root == null)
			return false;
		if(root.data == target)
			return true;
		return search(root.left, target) || search(root.right, target);
	}
	
	static boolean searchNodeBestWay(Node root, int target)
	{
		if(root == null)
			return false;
		
		if(root.data == target)
			return true;
		
		boolean left = searchNodeBestWay(root.left, target);
		
		if(left)
			return left;
		else
		{
			boolean right = searchNodeBestWay(root.right, target);
			return right;
		}
	}

	public static void main(String [] args)
	{
		insertNode(58);
		insertNode(45);
		insertNode(62);
		insertNode(59);
		insertNode(42);
		insertNode(75);
		insertNode(20);
        
		out.print(searchNodeBestWay(root, 59));
	}
}