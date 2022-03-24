/*
** https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
** T(n) : O(n) 
** S(n) : O(1)
** Yet to be solved
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
	   right = left = null;
	}
}

public class FixTheBSTIfTwoNodesAreSwapped
{
    static void fixBst(Node root)
	{
		
	}	
	
	public static void main(String[] args)
	{
		  Node root = new Node(50);
		  Node r2 = new Node(45);
		  Node r3 = new Node(90);
		  Node r4 = new Node(40);
		  Node r5 = new Node(46);
		  Node r6 = new Node(85);
		  Node r7 = new Node(95);
		  Node r8 = new Node(93);
		  Node r9 = new Node(42);
		  Node r10 = new Node(43);
		  Node r11 = new Node(92);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;
          
		  inorder(root);
		  out.println();
		  fixBst2(root);
		  inorder(root);
 	}
}
