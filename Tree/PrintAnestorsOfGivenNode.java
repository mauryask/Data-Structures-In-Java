/**
  Time complexity: O(n)
  Space complexity: O(height) + O(height) = O(h) 
  : recursion stack + path stack
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		right = left = null;
	}
}

class Ancestor 
{
	boolean flag = false;
}

public class PrintAnestorsOfGivenNode
{
    // list to record ancestors
	static List<Integer> list = new ArrayList<>();
	
    static boolean findAncestor(Node root, int target)
	{
		if(root == null)
	        return false;
		
		if(root.data == target)
			return true;
		
		boolean left = findAncestor(root.left, target);
		if(left)
		{
			list.add(root.data);
			return true;
		}
		else
		{
			boolean right = findAncestor(root.right, target);
			if(right)
			{
				list.add(root.data);
				return true;
			}
		}
		
		return false;
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
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		r5.left = r8;
		r5.right = r9;
		r4.right = r10;
		
		findAncestor(root, 10);
		
		for(int x: list)
			out.print(x+" ");
	}
}