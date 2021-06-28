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

class Answer 
{
	int sum = 0;
	boolean isPathExist = false;
	Stack<Node> path = new Stack<>();
}

public class CheckIfPathWithRequiredSumExists
{
   static void inorder(Node root,
   Answer answer, int requiredSum)
   {
	   if(root != null)
	   {
		   answer.path.push(root);
		   answer.sum += root.data;
		   inorder(root.left,answer, requiredSum);
		   if(root.right == null && root.left == null)
		   {
			   if(answer.sum == requiredSum)
				answer.isPathExist = true;				   
		   }
		   inorder(root.right,answer,requiredSum);
		   answer.path.pop();
		   answer.sum -= root.data;
	   }
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
			 
			  Answer answer = new Answer();
			  inorder(root,answer,15);
			  out.println(answer.isPathExist);
		}
}
