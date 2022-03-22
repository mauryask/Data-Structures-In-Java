/*
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

   static int dist = 0;
   // path order is not correct so fix it
   // you can use two diffrent lists to
   // store left and right path separately
   static List<Integer> path = new ArrayList<>();
   
   static boolean findPAthLength(Node root, int d1, int d2)
   {
	   if(root == null)
		   return false;
	   if(root.data ==d1 || root.data == d2)
	   {
		   dist++;
		   path.add(root.data);
		   return true;
	   }
	   
	   boolean left = findPAthLength(root.left,d1, d2);
	   if(left)
	   {
		   dist++;
		   path.add(root.data);
		   return true;
	   }
	   else
	   {
		   boolean right  = findPAthLength(root.right, d1, d2);
		   if(right)
		   {
			  dist++;
			  path.add(root.data);
			  return true;
		   }
		   
	   }
	   
	   return false;
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
		
		// LCA
	    Node node = findLCA(root,8,39);
		// find left distance
	    findPAthLength(node.left, 8, 39);
		int leftDist = dist;
		dist = 0;
		path.add(node.data);
		// find right distance
		findPAthLength(node.right, 8,39);
		int rightDist = dist;
		// total nodes in the path totalDist =  leftDist + rightDist +1 
		// Hence distacne  = eftDist + rightDist
		
		out.println(leftDist+rightDist);
		
		out.println("--------------");
		for(int x: path)
			out.print(x+" ");
	}
}