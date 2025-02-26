import static java.lang.System.*;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

class QueueData 
{
	int dd;
	Node node; 
	
	QueueData(Node node, int dd){
		this.dd = dd;
		this.node = node;
	}
}

public class PrintDiagonalView
{
		static void topView(Node root)
		{
			List<QueueData> q = new LinkedList<>();
			Map<Integer, List<Integer>> map = new TreeMap<>();
			q.add(new QueueData(root, 0));
			
			while(!q.isEmpty())
			{
				QueueData queueData = q.remove(0);
				int dd = queueData.dd;
				Node node = queueData.node;
				
			    List<Integer> list = map.getOrDefault(dd, new ArrayList<Integer>());
				list.add(node.data);
				map.put(dd, list);
				
				if(node.left != null)
					q.add(new QueueData(node.left, dd+1));
				if(node.right != null)
				    q.add(new QueueData(node.right, dd));	
             }
			 
			 for(Map.Entry<Integer, List<Integer>> m : map.entrySet())
			 {
				 out.println(m.getKey()+" : "+m.getValue());
			 }
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
          
		  topView(root);
		}
}
