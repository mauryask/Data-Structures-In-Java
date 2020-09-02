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

public class InvertBinaryTree
{
	static void invert(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{			
			    root = q.poll();
			
		        Node temp = root.right;
				root.right = root.left;
				root.left = temp;				

				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);
		}
	}
	
	static void preorder(Node root)
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String [] args)
	{
		Node root = new Node(1);
		Node n2  = new Node(2);
		Node n3  = new Node(3);
		Node n4  = new Node(4);
		Node n5  = new Node(5);
		Node n6  = new Node(6);
		Node n7  = new Node(7);
		
		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		preorder(root);
		invert(root);
		System.out.println("\nAfter inversion: ");
		preorder(root);
	}
}