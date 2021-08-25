/**
Time complexity   : O(n)
Spasce complexity : O(n) 
This approach is combination of levelorder traversal
and Map
Each entry in map conatins Hd as key and an ArrayList containing
node values with the same Hd
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

public class VerticalOrderTraversal
{
	static void verticalOrderTraversal(Node root)
	{
		Queue<QueueData> q = new ArrayDeque<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		q.add(new QueueData(root,0));
		
		List<Integer> list = new LinkedList<>();
		list.add(root.data);
		map.put(0,list);
	     
        while(!q.isEmpty())
		{
			QueueData qd =  q.poll();
			root = qd.node;
			
			if(root.left != null)
			{
				q.add(new QueueData(root.left,qd.hd-1));
				if(!map.containsKey(qd.hd-1))
				{
					list = new LinkedList<>();
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
					list = new LinkedList<>();
					list.add(root.right.data);
					 map.put(qd.hd+1, list);
				}
				else
					map.get(qd.hd+1).add(root.right.data);
			}
		}	

       // printing nodes along each vertical line
	   for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
		   out.println(m.getKey()+" => "+m.getValue());	   
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
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  
		  verticalOrderTraversal(root);
	}
}