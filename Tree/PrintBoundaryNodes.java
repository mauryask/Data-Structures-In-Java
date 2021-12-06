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

public class PrintBoundaryNodes
{
	// O(n)
	static void leftBoundary(Node root, List<Integer> list)
	{
		if(root == null)
			return;
		if(root.left != null)
		{
			list.add(root.data);
			leftBoundary(root.left, list);
		}
		else if(root.right != null)
		{
			list.add(root.data);
			leftBoundary(root.right, list);
		}
	}
	
	// O(n)
	static void leafNode(Node root, List<Integer> list)
	{
		if(root == null)
			return;
		leafNode(root.left, list);
		if(root.left == null && root.right == null)
			list.add(root.data);
		leafNode(root.right, list);
	}
	
	// O(n)
	static void rightBoundary(Node root, List<Integer> list)
	{
	   if(root == null)
        return;
       if(root.right != null)
	   {
		   rightBoundary(root.right, list);
		   list.add(root.data);
	   }		   
	   else if(root.left != null)
	   {
		   rightBoundary(root.left, list);
		   list.add(root.data);
	   }
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

          List<Integer> list = new ArrayList<>();
		  list.add(root.data);
		  leftBoundary(root.left, list);
		  leafNode(root, list);
		  rightBoundary(root.right, list);
		  out.println(list);
	}
}
