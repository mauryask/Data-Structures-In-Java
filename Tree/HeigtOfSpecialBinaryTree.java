/*
* https://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected/
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

public class HeigtOfSpecialBinaryTree 
{
	/*
	* T(n) : O(n)
	* S(n) : O(n)	
	*/
    static int findHeight(Node root) {
       if(root == null) return 0;
       
       if(root.right != null && root.right.left == root) return 0;
       
       int lh = findHeight(root.left);
       int rh = findHeight(root.right);
       
       return Math.max(lh, rh) + 1;
    }
	
	public static void main(String args[])
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
		  r4.left = r8;
		  
		  // Create DLL of leaf nodes 
		  r8.right = r5;
		  r5.left = r8;
		  r5.right = r6;
		  r6.left = r5;
		  r6.right = r7;
		  r7.left = r6;
		  r8.left = r7;
		  r7.right = r8;
		  
		  out.println(findHeight(root));
	}
}