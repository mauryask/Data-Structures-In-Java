/**
Time complexity  : O(n^2)
Space complexity : O(n)
*/

import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;0
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
	   // O(n)
	   if(root != null)
	   {
		   answer.path.push(root);
		   inorder(root.left,answer, requiredSum);
		   inorder(root.right,answer,requiredSum);
		   
		   // O(n)
		   // it is being done for each node
		   int sum = 0;
		   for(int i = answer.path.size()-1; i>=0; i--)
		   {
			   sum += answer.path.get(i).data;
			   if(sum == requiredSum)
				    printPath(answer.path, i);
		   }
		   
		   // once done with a node pop it from path stack
		   answer.path.pop();
	   }
   }	
   
   static void printPath(Stack<Node> path, int j)
   {
	   for(int i=j; i<path.size(); i++)
		out.print(path.get(i).data+" ");
	   out.println();
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
			  // print all paths with sum k = 7
			  inorder(root, answer, 7);
		}
}
