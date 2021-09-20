/*
* Time complexity   : O(n)
* Spasce complexity : O(n) 
* See vertical order traversal first
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

// This class object contains node value along 
// with its distance from left line
class QueueData
{
	Node node;
	int hd;
	
	QueueData(Node node, int hd)
	{
		this.hd = hd;
		this.node= node;
	}
}

public class VerticalOrderSum
{
	static void verticalOrderSum(Node root)
	{
		Queue<QueueData> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();
         
		q.add(new QueueData(root,0));
	
        while(!q.isEmpty())
		{
			QueueData qd =  q.remove();
			root = qd.node;
			int hd = qd.hd;
			
			/*
			* If hd is already present in the map 
			* get existing sum and current root data 
			* into it and put it n the map 
			* else get 0 as sum
			**/
			int sum = map.getOrDefault(hd,0);
			map.put(hd, sum+root.data);
			
			if(root.left != null)
				q.add(new QueueData(root.left,hd-1));
			
			if(root.right != null)
				q.add(new QueueData(root.right,hd+1));
		}	

       // printing vertical sum along each vertical line
	   for(Map.Entry<Integer, Integer> m : map.entrySet())
	   {
		   out.println(m.getKey()+" ==> "+ m.getValue());
	   }	   
		
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
		  
		  root.left = r2;
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
		  r7.right = r15;
		  
		  verticalOrderSum(root);
	}
}