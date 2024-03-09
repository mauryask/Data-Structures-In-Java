 /**
Time complexity  : O(n)
Space complexity : O(n)
Quetion Number : 69 (Made Easy BST)
:: Means same shape as well
*/

import java.util.*;
import static java.lang.System.*;

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


public class CheckIfTwoBstsHasSameElelments 
{	
   static Node createBST(Node root, int data)
	{
		Node currentNode = null, parentNode = null;
		Node temp = new Node(data);
		
		if(root == null)
			root = temp;
		else
		{
			currentNode = root;
			while(currentNode != null)
			{
				parentNode = currentNode;
				
				if(currentNode.data > data)
					currentNode = currentNode.left;
				else if(currentNode.data < data)
					currentNode = currentNode.right;
			}
			
			if(parentNode.data > data)
				parentNode.left = temp;
			else
				parentNode.right = temp;
		}
		return temp;
	}
 
    static boolean isSame(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
			return true;
			 
		if(root1 == null || root2 == null)
			return false;
		
		return root1.data == root2.data 
			&& isSame(root1.left, root2.left) 
			&& isSame(root1.right, root2.right);		
	}

	public static void main(String [] args)
	{
        Node root1 = null;
		root1 = createBST(root1, 10);
		createBST(root1, 20);
		createBST(root1,15);
		createBST(root1, 30);
		createBST(root1, 5);
		
        Node root2 = null;
		root2 = createBST(root2, 10);
		createBST(root2,5);
		createBST(root2, 20);
		createBST(root2, 15);
		createBST(root2, 30);
		
		out.println(isSame(root1, root2));
	}
}
