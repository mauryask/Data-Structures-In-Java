/**
Time complexity   : O(n)
Spasce complexity : O(n)
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

class QueueData
{
	Node node;;
	int hd;
	
	QueueData(Node node, int hd)
	{
		this.hd = hd;
		this.node= node;
	}
}

public class VerticalOrderTraversal
{
	static void verticalOrderTraversal(Node root)
	{
		Queue<QueueData> q = new ArrayDeque<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
         
		q.add(new QueueData(root,0));
		List<Integer> list = new ArrayList<>();
		list.add(root.data);
		map.put(0,list);
	     
        while(!q.isEmpty())
		{
			QueueData qd =  q.remove();
			root = qd.node;
			
			if(root.left != null)
			{
				q.add(new QueueData(root.left,qd.hd-1));
				if(!map.containsKey(qd.hd-1))
				{
					 list = new ArrayList<>();
					 list.add(root.left.data);
					 map.put(qd.hd-1, list);
				}
				else
					map.get(qd.hd-1).add(root.left.data);
			}
			
			if(root.right != null)
			{
				q.add(new QueueData(root.right, qd.hd+1));
				if(!map.containsKey(qd.hd+1))
				{
					 list = new ArrayList<>();
					 list.add(root.right.data);
					 map.put(qd.hd+1, list);
				}
				else
					map.get(qd.hd+1).add(root.right.data);
			}
		}	

	   for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
	   {
		   for(int x: m.getValue())
		   out.print(x+" ");
	       out.println();
	   }	   
		
	}
		
	public static void main(String [] args)
	{
		  /*Node root = new Node(1);
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
		  Node r15 = new Node(15);*/
		  
		/*  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  r5.right = r11;
		  r6.left = r12;
		  r6.right = r13;
		  r7.left = r14;
		  r7.right = r15;*/
		  
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
		  
		  verticalOrderTraversal(root);
		  //preorder(root);
	}
}