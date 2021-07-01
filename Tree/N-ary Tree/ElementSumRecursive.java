/**
Time complexity: O(n)
Space complexity: O(n)
*/

import java.util.*;
import static java.lang.System.*;

class Node 
{
	int data;
	Node child, next;
	
	Node(int data)
	{
		this.data = data;
		child = next = null;
	}
}

public class ElementSumRecursive
{
	static void addSibliing(Node root, Node node)
	{
		while(root.next != null)
			root = root.next;
		root.next = node;
	}
	
	static void addChild(Node root, Node node)
	{
		if(root == null)
			return;
		if(root.child != null)
			addSibliing(root.child, node);
		else
			root.child = node;
	}
	
	// Recursive function
	static int sum(Node root)
	{
		if(root == null)
			return 0;
		return root.data + sum(root.child) + sum(root.next);
	}
	
	public static void main(String [] args)
	{
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		Node r8 = new Node(8);
		Node r9 = new Node(9);
		Node r10 = new Node(10);
		
		addChild(root, r2);
		addChild(root, r3);
		addChild(r2, r4);
		addChild(r2, r5);
		addChild(r2, r6);
		addChild(r5, r7);
		addChild(r5, r8);
		addChild(r5, r9);
		addChild(r9, r10);

		out.println(sum(root));
	}
}