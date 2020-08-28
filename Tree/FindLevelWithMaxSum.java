//getting the level number having maximum sum
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

public class FindLevelWithMaxSum
{
	static int findLevelOfMaxSum(Node root)
	{
		List<Node> q = new LinkedList<>();
		// we have taken here sum as the key
		// used tree map to sort map in descending order
		Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
		int sum = 0, level = 0;
		
		q.add(root);
		q.add(null);
		map.put(root.data, level);
		while(!q.isEmpty())
		{
			root = q.remove(0);
			
			if(root == null)
			{
				level++;
				if(!q.isEmpty())
				{
					q.add(null);
					// kept it here to prevent one extra 
					// and useless entry
					map.put(sum,level);
				    sum = 0;
				}				
			}
			else
			{
				if(root.left != null)
				{
					q.add(root.left);
					sum += root.left.data;
				}
				if(root.right != null)
				{
					q.add(root.right);
					sum += root.right.data;
				}
			}
		}
		
	 //getting first entry of of the map (that is the entry with max sum)	
	  Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
	  return entry.getValue(); //here value is level number
	}
	
	// this method shows how to find the 
	// level with maximum sum without using  hash table0
	// this is the best way than the previous
	
	static int method2(Node root)
	{
		int level = 0;
		int maxLevel = 0;
		int maxSum = 0;
		int currentSum = 0;
		
		List<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			root = q.remove(0);
			if(root == null)
			{
				if(currentSum > maxSum)
				{
					maxSum = currentSum;
					maxLevel = level;
				}
				currentSum = 0;
				if(!q.isEmpty())
				 q.add(null);
			 level++;
			}
			else
			{
				currentSum += root.data;
				if(root.left != null)
					q.add(root.left);
				if(root.right != null)
					q.add(root.right);
			}
		}
		return maxLevel;
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
		  
		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;	  
		  r4.left = r8;
		  r4.right = r9;
		  r5.left = r10;
		  
		System.out.println(findLevelOfMaxSum(root));
		System.out.println(method2(root));
		
		}
}
