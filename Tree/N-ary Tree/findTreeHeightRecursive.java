/**
Time complexity  : O(n)
Space complexity : O(n)
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

public class findTreeHeightRecursive
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
	
	// it returns exact height not the total levels
    static int findTreeHeightRecursive(Node root)
	{
		if(root == null)
			return 0;
		
		int childHeight = findTreeHeightRecursive(root.child);
		int siblingHeight = findTreeHeightRecursive(root.next);
		int maxHeight = Math.max(childHeight, siblingHeight);
		
		if(root.child != null)
			return maxHeight + 1;
		else
			return maxHeight;
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
		Node r11 = new Node(11);
		Node r12 = new Node(12);
		Node r13 = new Node(13);
		Node r14 = new Node(14);
		Node r15 = new Node(15);
		Node r16 = new Node(16);
		Node r17 = new Node(17);
		
		addChild(root, r2);
		addChild(root, r3);
		addChild(root, r4);
		addChild(r2, r8);
		addChild(r2, r9);
		addChild(r4, r5);
		addChild(r4, r6);
		addChild(r4, r14);
		addChild(r9, r10);
		addChild(r9, r11);
		addChild(r9, r12);
		addChild(r6, r7);
		addChild(r12, r13);
		addChild(r13, r16);
		addChild(r13, r17);
		addChild(r7, r15);
		
		out.println(findTreeHeightRecursive(root));
	}
}