/**
Time complexity  : O(n)
Space complexity : O(n)
*/

import static java.lang.System.*;
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

class Diameter
{
   int length = Integer.MIN_VALUE;
}

public class FindTreeDiameterBestWay
{
	// since the tree diameter is nothing but 
	// the max value of (lh+rh+1)
	// so we will do everything in height function itself
		
	static int height(Node root, Diameter diameter)
	{
		if(root == null)
			return 0;
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter.length = Math.max(diameter.length, lh+rh+1);
		return Math.max(lh, rh) + 1;
	}
		
	static void findDiameter(Node root, Diameter diameter)
	{
		if(root == null)
		{
			out.println("Tree height: 0");
			return;
		}
		
		int treeHeight = height(root, diameter);
		out.println("Tree height: "+treeHeight);
		out.println("Diameter length: "+ diameter.length);
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
			  r4.right = r8;
			  
			  findDiameter(root, new Diameter());
		}
}
