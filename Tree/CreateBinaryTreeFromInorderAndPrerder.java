/**
Time complexity  : O(n)
Space complexity : O(n) 
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
	}
}

public class CreateBinaryTreeFromInorderAndPrerder
{	
   static int preIndex = 0;

   static Node createTree(int in[], int pre[], int
   startIndex, int endIndex)
   {
	   if(startIndex > endIndex)
		   return null;
	   
	   Node root =  new Node(pre[preIndex++]);
	   
	   if(startIndex == endIndex)
		   return root;
	   
	   int inOrderIndex = search(in, startIndex, endIndex
	   , root.data);
	   	   
	   root.left = createTree(in, pre, startIndex, inOrderIndex-1);
	   root.right = createTree(in, pre, inOrderIndex+1, endIndex);
	   
	   return root;
   }
   
   static int search(int in[], int startIndex, int endIndex, int root)
   {
	   for(int i= startIndex; i<= endIndex; i++)
	   {
		   if(root == in[i])
			   return i;
	   }
	   return -1;
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
   
	public static void main(String [] args)
	{
	   int in[]  = {3,1,4,0,5,2};
	   int pre[] = {0,1,3,4,2,5};
	   int n = in.length;
	   Node root = createTree(in, pre, 0, n-1);
	   printTree(root);
	   out.println();
	}
}