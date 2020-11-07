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

public class CheckTwoBinaryTreeAreIdentical
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
	
	static boolean isIdentical(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data &&
		isIdentical(root1.left,root2.left)&&
		isIdentical(root1.right, root2.right));
	}
	
	  public static void main(String [] args)
		{
		
		//tree1
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
		  
		 //tree2
		  Node rootx = new Node(1);
		  Node rx2 = new Node(2);
		  Node rx3 = new Node(3);
		  Node rx4 = new Node(4);
		  Node rx5 = new Node(5);
		  Node rx6 = new Node(6);
		 
		 Node rx7 = new Node(7);
		  
		  rootx.left = rx2;
		  rootx.right = rx3;
		  rx2.left = rx4;
		  rx2.right = rx5;
		  rx4.left = rx6;
		  
		  rx4.right = rx7;
		  
		 System.out.println(isIdentical(root, rootx));
		 
		}
}
