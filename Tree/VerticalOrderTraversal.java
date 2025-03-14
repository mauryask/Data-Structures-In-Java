/*
* Time complexity   : O(n)
* Spasce complexity : O(n) 
* This approach is combination of 
* levelorder traversal and Map
* Each entry in map conatins Hd as
* key and an ArrayList containing
* node values with the same Hd
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

        while(!q.isEmpty())
		{
			QueueData qd =  q.poll();
			root = qd.node;
			int hd = qd.hd;
  
  			/*
			* If hd is not present in the map 
			* create getOrDefault will return a new list
			* and add root.data to that
			* if hd is already present get existing list and add 
			* root.data and put it in the map			
			*/
			
            List<Integer> list =  map.getOrDefault
			(hd, new ArrayList<Integer>());
            list.add(root.data);
			
		    map.put(hd, list);
					
			if(root.left != null)
				q.add(new QueueData(root.left,hd-1));
			if(root.right != null)
				q.add(new QueueData(root.right,hd+1));
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
		  Node r4 = new Node(6);
		  Node r5 = new Node(9);
		  Node r6 = new Node(5);
		  Node r7 = new Node(4);
		  Node r8 = new Node(0);
		  Node r9 = new Node(8);
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r5.left = r8;
		  r8.right = r9;
		  
		  verticalOrderTraversal(root);
	}
}