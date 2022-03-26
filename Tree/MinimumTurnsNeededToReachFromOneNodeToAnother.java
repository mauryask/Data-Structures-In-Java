/*
* T(n) : O(n) 
* S(n) : O(1)
** https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
	   this.data = data;
	   left = right = null;
	}
}

public class MinimumTurnsNeededToReachFromOneNodeToAnother 
{
	static Node findLCA(Node root, int a, int b)
	{
		if(root == null)
			return null;
		if(root.data == a || root.data == b)
			return root;
		
		Node left = findLCA(root.left, a, b);
		Node right = findLCA(root.right, a, b);
		
		if(left != null && right != null)
			return root;
        return  left == null ? right : left;
	}
	
	static String prev = "X";
	static int srcTurnCount = 0;
	static int destTurnCount = 0;
	
	static boolean
	turnCount(Node root, int k, boolean isSource)
	{
        if(root == null)
		  return false;			
	    
		if(root.data == k)
			return true;
		
		boolean left = turnCount(root.left, k, isSource);
		
		if(left)
		{
			if(isSource)
				srcTurnCount = 1;
			else
			{
				if(prev != "L")
				{
					prev = "L";
					destTurnCount++;
				}
			}
			return true;
		}
		else
		{
			boolean right = turnCount(root.right, k, isSource);
			if(right)
			{
				if(isSource)
					srcTurnCount = 1;
				else
				{
					if(prev != "R")
					{
						prev = "R";
					    destTurnCount++;
					}
				}
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
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r7.right = r8;
		  
		  int src = 4;
		  int dest = 1;
		  
		  Node lca = findLCA(root, src, dest);
		  turnCount(lca, src, true);
		  turnCount(lca, dest, false);
		  
		  out.println(srcTurnCount + destTurnCount);
	}
}