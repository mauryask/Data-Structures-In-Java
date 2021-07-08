/**
Time complexity  : O(n)
Space complexity : O(n)
The program also demonstrates ho to print the 
shortest path as well
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

public class shortestParthLengthBetweenTwoGivenNodes
{	
  static Node createBST(Node root, int data)
  {
	 Node temp = new Node(data);
	 Node currentNode = null, parentNode = null;
	 
	 if(root == null)
		 root = temp;
	 else
	 {
		 currentNode = root;
		 while(currentNode != null)
		 {
			 parentNode = currentNode;
			 if(currentNode.data < data)
				 currentNode = currentNode.right;
			 else if(currentNode.data > data)
				 currentNode = currentNode.left;
		 }
		 
		 if(parentNode.data < data)
			 parentNode.right = temp;
		 else
			 parentNode.left = temp;
	 }
	 
	  return temp;
  }
  
  
  // T(n) = O(n)
  // S(n) = O(n)
  static Node findLCA(Node root, int d1, int d2)
  {
	  if(root == null)
		  return null;
	  
	  if(root.data == d1 || root.data == d2)
		  return root;
	  
	  Node left = findLCA(root.left, d1, d2);
	  Node right = findLCA(root.right, d1, d2);
	  
	  if(left != null && right != null)
		  return root;
	  else 
		  return left != null ? left : right;
  }
  
  
  // The shortest path is going to be
  // sum of distances of both nodes from their
  // lowest common ancestor
  
  
   static Stack<Integer> stack = null;
   static int findpathLength(Node root, int n1, int n2)
   {
	   if(root == null)
		   return -1;
	   
	   // find the LCA
	   Node lca = findLCA(root, n1, n2);
	   
	   if(lca == null)
		   return -1;
	   
	   // distance of first node from lca
	   stack = new Stack<>();
	   int d1 = findDistance(lca, n1);
	  // print stack form bottom to top
	  
	  for(int x : stack)
		  out.print(x+" ");
	   
	   // distance of second node from lca
	   stack = new Stack<>();
	   int d2 = findDistance(lca, n2);
	   stack.pop();
	   // print stack from top to bottom
	   
	   while(!stack.isEmpty())
		   out.print(stack.pop()+" ");
	   
	   // the shortest path length
	   return d1 + d2;
   }
   
     // T(n) = O(n)
     // S(n) = O(n)
   static int findDistance(Node node, int n)
   { 
	   if(node == null)
		   return -1;

	   if(node.data == n) 
	   {
		   stack.push(node.data);
		   return 0;
	   }
	   
	   int ld = findDistance(node.left, n);
	   
	   // ld is not negative means 
	   //required node found in the left subtree
	   if(ld != - 1) 
	   {
		   stack.push(node.data);
		   return ld+1;
	   }
	   else // if ld is -ve make a call for right subtree
	   {
		   int rd = findDistance(node.right, n);
		   if(rd == -1)
			   return -1;
		   else
		   {
			   stack.push(node.data);
			   return rd+1;
		   }
	   }
   }

   static void printStack()
   {
	   for(int x: stack)
		   out.print(x+" ");
   }


	public static void main(String [] args)
	{
        Node root = null;
		root = createBST(root, 44);
		createBST(root, 35);
		createBST(root,20);
		createBST(root, 10);
		createBST(root, 58);
		createBST(root, 36);
		createBST(root, 78);
		createBST(root, 12);
		createBST(root, 8);
		createBST(root, 23);
		createBST(root, 37);
		createBST(root, 38);
		createBST(root, 39);
		
	   // Node node = findLCA(root,35,39);
	   out.println("Printing the shortest path");
	    int dist = findpathLength(root, 8,23);
		out.println();
		out.println("Shortest Path length: "+ dist);
	}
}