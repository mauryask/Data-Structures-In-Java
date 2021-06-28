/**
Time complexity: O(n^2)
Space complexity: O(n)
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
		left = right = null;
	}
}

public class FindTreeDiameterRecursive
 {
	static int findDiameter(Node root)
	{	
	   if(root== null)
		   return 0;
	
	    int lh = getHeight(root.left);
		int rh = getHeight(root.right);

        // the actual recursion begin from here
		int ld = findDiameter(root.left);
		int rd = findDiameter(root.right);
		
		return Math.max(lh+rh+1, Math.max(ld, rd));
	} 

	// for each node this function is being called
	// that is hearting us most
	// it causes time complexity : O(n^2)
    static int getHeight(Node root)
	{
		if(root==null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}	
	
	static void printTree(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
    public static void main(String args[] ) throws Exception
	{
		Node root = new Node(1);
		Node r2 = new Node(2);
		Node r3 = new Node(3);
		Node r4 = new Node(4);
		Node r5 = new Node(5);
		Node r6 = new Node(6);
		Node r7 = new Node(7);
		
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		
		out.println(findDiameter(root));	
    }

}
