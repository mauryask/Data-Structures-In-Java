/**
Time complexity  : O(n)
Space complexity : O(n)
Note: 
Isomorphic means there structure is same
But values of the nodes might be different
*/
import java.util.*;
import static java.lang.System.*;

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

public class CheckIfTwoTreesIsomorphic
{

   static boolean isIsomorphic(Node root1, Node root2)
   {
	   if(root1 == null && root2 == null)
		   return true;
	   if(root1 == null && root2 != null)
		   return false;
	   if(root1 != null && root2 == null)
		   return false;
	   
	   Queue<Node> q1 = new ArrayDeque<>();
	   Queue<Node> q2 = new ArrayDeque<>();
	   q1.add(root1);
	   q2.add(root2);
	   
	   while(!q1.isEmpty() && !q2.isEmpty())
	   {
		   root1 = q1.remove();
		   root2 = q2.remove();
		   
		   if(root1.left != null && root2.left != null)
		   {
			   q1.add(root1.left);
			   q2.add(root2.left);
		   }
		   else if(root1.left != null || root2.left != null)
		      return false;
		  
		  if(root1.right != null && root2.right != null)
		  {
			  q1.add(root1.right);
			  q2.add(root2.right);
		  }
		  else if(root1.right != null || root2.right != null)
			  return false;
	   }

	   return true;
   }
   
   // time complexity  : O(n)
   // Space complexity : O(n)
  static boolean checkIsomorphicRecursive(Node root1, Node root2)
   {
	   if(root1 == null && root2 == null)
		   return true;
	   if(root1 != null && root2 == null)
		   return false;
	   if(root1 == null && root2 != null)
		   return false;
	   
	   boolean left = checkIsomorphicRecursive(root1.left, root2.left);
	   boolean right = checkIsomorphicRecursive(root1.right, root2.right);	 

	   return left && right;
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
		r5.right = r6;
		r6.left = r7;
		r6.right = r8;
		
		Node rootx = new Node(1);
		Node r2x = new Node(2);
		Node r3x = new Node(3);
		Node r4x = new Node(4);
		Node r5x = new Node(5);
		Node r6x = new Node(6);
		Node r7x = new Node(7);
		Node r8x = new Node(8);
		
		rootx.left = r2x;
		rootx.right = r3x;
		r2x.left = r4x;
		r2x.right = r5x;
		r5x.right = r6x;
		r6x.left = r7x;
		r6x.right = r8x;
		
		out.println(checkIsomorphicRecursive(root,rootx));
		
	}
}