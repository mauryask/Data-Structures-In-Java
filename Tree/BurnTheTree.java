/*
* T(n) : O(n*k)
* S(n) : O(n)
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

public class BurnTheTree
{
   static boolean nodeToRootPath(Node root, Node target, 
   List<Node> path)
   {
       if(root == null)
           return false;
       
       if(root == target)
       {
           path.add(root);
           return true;
       }
       
       boolean left = nodeToRootPath(root.left, target, path);
       
       if(left)
       {
           path.add(root);
           return true;
       }
       else
       {
           boolean right = nodeToRootPath(root.right, target, path);
           if(right)
           {
               path.add(root);
               return true;
           }
       }
       
       return false;
   }
  
   static int maxTime =  Integer.MIN_VALUE;
  
   static void printNode(Node root, Node blocker, int time, List<Integer> list)
   {
       if(root == null || root == blocker)
           return; 
       
	   //  recording the sequence in which the 
       //  the tree wil be burnt 	   
	   list.add(root.data);
       
       if(root.left == null || root.right == null)
            maxTime  = Math.max(maxTime, time);
        
       printNode(root.left, blocker, time+1, list);
       printNode(root.right, blocker, time+1, list);
   }

   static void printKfarNodes(Node root, Node target)
   {
        List<Node> path = new ArrayList<>();
        nodeToRootPath(root,target, path); 
		
		List<Integer> list =  new ArrayList<>();
        
        int time = 0;
        
        for(int i=0 ; i<path.size(); i++)
            printNode(path.get(i), i==0? null : path.get(i-1), time+i, list);
        
		for(int x: list)
			out.print(x+" ");
        out.println(maxTime);
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
		Node r9 = new Node(9);
		Node r10 = new Node(10);
		Node r11 = new Node(11);
		Node r12 = new Node(12);
		Node r13 = new Node(13);
		Node r14 = new Node(14);
		Node r15 = new Node(15);
		Node r16 = new Node(16);
		Node r17 = new Node(17);
		
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
     	r3.right = r7;
		r5.left = r8;
		r5.right = r9;
		r6.right = r10;
		r10.left = r13;
		r7.left = r12;
		r7.right = r11;
	    
        printKfarNodes(root, r13);
    }
}