/*
** https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
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
	   right = left = null;
	}
}

class Parent 
{
	int parent;
    int level;
		
	Parent(int parent, int level)
	{
		this.parent = parent;
		this.level = level;
	}		
}

public class CheckIfTwoNodesAreCousins
{
	// T(n) : O(n)
	// S(n) : O(n)
	
	static boolean isCousin(Node root, int a, int b)
	{
		/*
		* Map maintains parent and level
		* number of the node
		*/
		
		Map<Integer, Parent> map = new HashMap<>();
		List<Node> q = new LinkedList<>();
		q.add(root);
		// parent of node is -1 and level is 0
		map.put(root.data, new Parent(-1, 0));
		boolean aFound = false;
		boolean bFound = false;
		
		while(!q.isEmpty())
		{
			// Don't need to traverse the 
			// tree further if both nodes have been found
			
			if(aFound && bFound)
				break;
			
			root = q.remove(0);
			int level = map.get(root.data).level;
			
			if(root.data == a)
				aFound = true;
			if(root.data == b)
				bFound = true;
			
			if(root.left != null)
			{
				q.add(root.left);
				map.put(root.left.data, new Parent(root.data, level+1));
			}
			if(root.right != null)
			{
				q.add(root.right);
				map.put(root.right.data, new Parent(root.data, level+1));
			}				
		}
		
		// if nodes rae not present in the tree
		// return get null
		Parent p1 = map.getOrDefault(a, null);
		Parent p2 = map.getOrDefault(b, null);
		
		return (p1!=null && p2!=null) && (p1.parent != p2.parent) && (p1.level == p2.level);
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(20);
		  Node r2 = new Node(8);
		  Node r3 = new Node(22);
		  Node r4 = new Node(4);
		  Node r5 = new Node(12);
		  Node r6 = new Node(25);
		  Node r7 = new Node(10);
		  Node r8 = new Node(14);
		  Node r9 = new Node(23);
		  Node r10 = new Node(52);
		  Node r11 = new Node(7);

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		  r4.right = r8;
		  r8.right = r10;
		  r7.left = r9;
		  r9.left = r11;
          
		  out.println(isCousin(root, 15, 7));
 	}
}
