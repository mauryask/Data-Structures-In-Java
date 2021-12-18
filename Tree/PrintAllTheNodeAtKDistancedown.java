/*
* T(n) : O(n)
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

public class PrintAllTheNodeAtKDistancedown
{
   static void printNode(Node root, int k)
   {
       if(root == null || k < 0)
          return;
      
       if(k == 0)
       {
           out.print(root.data+" ");
           return;
       }
       
       printNode(root.left, k-1);
       printNode(root.right, k-1);
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
		
		printNode(root, 3);
	}
}