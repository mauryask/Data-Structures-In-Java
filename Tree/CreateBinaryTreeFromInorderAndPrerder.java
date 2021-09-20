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
   startIndex, int endIndex, Map<Integer, Integer> map)
   {
	   if(startIndex > endIndex)
		   return null;
	   
	   Node root =  new Node(pre[preIndex++]);
	   
	   if(startIndex == endIndex)
		   return root;
	   
	   /*
	   * Map is being used to overcome linear searching
	   * get inorder index in O(1) 
	   */
	   int inOrderIndex = map.get(root.data);/*search(in, startIndex, endIndex
	   , root.data);*/
	   	   
	   root.left = createTree(in, pre, startIndex, inOrderIndex-1, map);
	   root.right = createTree(in, pre, inOrderIndex+1, endIndex, map);
	   
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
	   int n = 6;
	   
	   /*
	   * Map is being used to overcome the 
	   * The disadvantages of the linear search
	   * since it causes O(n*n) time complexity
	   * while searching while same task can be performed  
	   * in O(1) using map
	   */
	   Map<Integer, Integer> map = new HashMap<>();
	   for(int i=0; i<n; i++)
		   map.put(in[i] , i);
	   
	   Node root = createTree(in, pre, 0, n-1, map);
	   printTree(root);
	   out.println();
	}
}