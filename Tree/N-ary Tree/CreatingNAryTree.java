/**
Time compelxity : O(n^2) // as to insert each node 
* we need to traverse a number of siblings (n-nodes)
* in worst caase
Space complexity: O(n) : recursion stack
*/

import java.util.*;
import static java.lang.System.*;

class Node
{
	int data;
	Node child;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		child = next = null;
	}
}

public class CreatingNAryTree
{
	static Node createNode(int data)
	{
		Node n = new Node(data);
		return n;
	}
	
	static void addSiblings(Node root, Node node)
	{
			while(root.next!=null)
				root = root.next;
			root.next = node;		
	}
	
	static void addChild(Node root,Node node)
	{		
		if(root ==  null)
			return;
		if(root.child != null)
		    addSiblings(root.child, node);
		else
		   root.child = node;
	}
	
    //Time complexity O(n)
	// Space complexity: O(n)
	// it is inorder traversal
	
	static void traversal(Node root) 
	{
		if(root != null)
		{
		    out.print(root.data+" ");
			traversal(root.child);
			traversal(root.next);	
		}
	}
	
	//level order traversal	
	// time complexity: O(n)
	// Space complexity: O(n)
	static void levelOrderTraversal(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root = q.remove();
			out.print(root.data+" ");
			
			// push the entire level in the q (all the chilren)
			root = root.child;
			while(root != null)
			{
				q.add(root);
				root = root.next;
			}
		}
	}
	
	public static void main(String[] args) 
	{
	   Node root = new Node(12);
	   Node n1 = new Node(2); 
       Node n2 = new Node(3);  
       Node n3 = new Node(4);
       Node n4 = new Node(14);
       Node n5 = new Node(12);
       Node n6 = new Node(6);
       Node n7 = new Node(7); 
       Node n8 = new Node(8); 
       Node n9 = new Node(9);
       Node n10 = new Node(23);
       
	   addChild(root, n1);
	   addChild(root, n2);
	   addChild(root, n3);
	   addChild(root, n4);
	   addChild(n2,n5);
	   addChild(n2,n6);
	   addChild(n3,n7);
	   addChild(n7,n8);
	   addChild(n7,n9);
	   addChild(n8,n10);
	   
       traversal(root);
  
       //levelOrderTraversal(root);
	}
}
