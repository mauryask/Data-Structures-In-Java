/*
* T(n) : O(n) 
* S(n) : O(1)
** https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
	   this.data = data;
	   left = right = null;
	}
}

public class MinimumTurnsNeededToReachFromOneNodeToAnother 
{
    static String prev = "X";
	static int count = 0;
    
    static Node getLca(Node root, int first, int second)
    {
        if(root == null)
          return null;
        
        if(root.data == first || root.data == second)
           return root;
           
        Node left = getLca(root.left, first, second);
        Node right =  getLca(root.right, first, second);
        
        if(left != null && right != null)
          return root;
        
        return left == null ? right : left;  
    }
        
    static boolean turnCount(Node root, int value)
    {
        if(root == null)
          return false;
          
        if(root.data == value)
            return true;
            
        boolean left = turnCount(root.left, value);
        
        if(left)
        {
            if(!prev.equals("L"))
            {
                prev = "L";
                count++;
            }
            
            return true;
        }
        else
        {
            boolean right = turnCount(root.right, value);
            
            if(right)
            {
                if(!prev.equals("R"))
                {
                    prev = "R";
                    count++;
                }
            }
            
            return right;
        }
        
    }
    
    static int NumberOfTurns(Node root, int first, int second)
    {
        Node lca = getLca(root, first, second);
		
		out.println(lca.data);
		
        turnCount(lca, first);
        int count1 = count;
		
		out.println(count1);
		
        count = 0;
        prev = "X";
		
        turnCount(lca, second);
		
		out.println(count);
		
        return count1 + count - 1;
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
		  
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r7.right = r8;
		  
		  r4.left = r9;
		  r4.right = r10;
		  r5.right = r11;
		  r7.left = r12;
		  
		  int src = 11;
		  int dest = 5;
		  
		  out.println(NumberOfTurns(root, src, dest));		  
	}
}