 /**
Time complexity  : O(n)
Space complexity : O(n)
Quetion Number : 69 (Made Easy BST)
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
		 Stack<Node> stack1 = new Stack<>();
		 Stack<Node> stack2 = new Stack<>();
		 
		 while(true)
		 {
			 while(root1 != null)
			 {
				 stack1.push(root1);
				 root1 = root1.left;
			 }
			 
			 while(root2 != null)
			 {
				 stack2.push(root2);
				 root2= root2.left;
			 }
			 
			 
			 if(stack1.isEmpty() || stack2.isEmpty())
				 break;
			 
			 root1 = stack1.pop();
			 root2 = stack2.pop();
			 
			 if(root1.data != root2.data)
				 return false;
			 
			 root1 = root1.right;
			 root2 = root2.right;
		 }
		 
		 return true;
	 }
 

	public static void main(String [] args)
	{
        Node root1 = null;
		root1 = createBST(root1, 44);
		createBST(root1, 35);
		createBST(root1,20);
		createBST(root1, 10);
		createBST(root1, 58);
		createBST(root1, 36);
		createBST(root1, 78);
		createBST(root1, 12);
		createBST(root1, 8);
		createBST(root1, 23);
		
        Node root2 = null;
		root2 = createBST(root2, 44);
		createBST(root2,20);
		createBST(root2, 8);
		createBST(root2, 10);
		createBST(root2, 35);
		createBST(root2, 58);
		createBST(root2, 12);
		createBST(root2, 23);
		createBST(root2, 36);
		createBST(root2, 78);

		
		out.println(isSame(root1, root2));
	}
}