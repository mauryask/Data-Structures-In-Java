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

public class PrintAllKSumPaths
{
   static  int sum = 0;
   static Stack<Integer> stack = new Stack<>();
	
   static void kSumPath(Node root, int k)
   {	   
	   if(root == null)
		   return;
	   
	   sum += root.data;
	   stack.push(root.data);
	   
	   if(sum == k)
		   printPath(stack);
	   
	   kSumPath(root.left, k);
	   kSumPath(root.right, k);
	   
	   sum -= root.data;
	   stack.pop();	   
   }
   
   
   static void printPath(Stack<Integer> stack)
   {
	   for(int x : stack)
		   out.print(x+" ");
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
			 
			 
			 kSumPath(root, 7);
		}
}
