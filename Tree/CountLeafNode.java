//finding total number of leaf node

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

public class CountLeafNode
{
	static void preOrder(Node root) 
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	static int countLeafNode(Node root)
	{
		List<Node> q = new LinkedList<>();
		q.add(root);
		int count =0;
		while(!q.isEmpty())
		{
			root = q.remove(0);
			
			//node that does not have left and right
			//child is a leaf node
			
			if(root.right == null && root.left == null)
			  count++;
			
			if(root.left != null)
				q.add(root.left);
			
			if(root.right != null)
				q.add(root.right);
		}
		return count;
	}
	
	
	  public static void main(String [] args)
		{
		
		  Node root = new Node(1);
		  Node r2 = new Node(2);
		  Node r3 = new Node(3);
		  Node r4 = new Node(4);
		  Node r5 = new Node(5);
		  Node r6 = new Node(6);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r4.left = r6;
		 
		 int totalLeafNode = countLeafNode(root);
		 System.out.println(totalLeafNode);
		}

}
