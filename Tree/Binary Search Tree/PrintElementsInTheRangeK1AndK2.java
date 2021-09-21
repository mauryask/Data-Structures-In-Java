/*
* Time complexity  : O(n)
* Space complexity : O(n)
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


public class PrintElementsInTheRangeK1AndK2
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
	
	static void printNode(Node root, int k1, int k2)
	{
		if(root == null)
			return;
		
		printNode(root.left, k1, k2);
		
		if(root.data >=k1 && root.data <= k2)
			out.print(root.data+" ");
		/*
		* If element exceeds then just break the 
		* stop further function calls since it is 
		* inorder traversal and after an element greater than k2 
		* no element will fall between k1 and k2
		*/
        else if(root.data > k2) 
			return;
		
		printNode(root.right, k1, k2);
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
		
		printNode(root, 45,80);
	}
}