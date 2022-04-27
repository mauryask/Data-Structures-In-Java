/*
* Here the concept is same as
* finding minimum number of swaps to 
* to sort the array
* T(n) : O(n * log n)
* S(n) : O(n)
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

class Element 
{
	int data;
	int index;
	
	Element(int data,int index)
	{
		this.data = data;
		this.index = index;
	}
}

public class MinSwapsToConvertTreeIntoBST
{
	static int minSwaps(Node root)
	{
		int swaps = 0;

		List<Element> list = new ArrayList<>();
        
        inorder(root, list);		
	
		Collections.sort(list, (a, b)->{
			return a.data - b.data;
		});
		
		int i = 0;
		
		while(i<list.size())
		{
		    Element ele = list.get(i);
			int index = ele.index;
			
			if(index != i)
			{
				list.set(i, list.get(index));
				list.set(index, ele);
				swaps++;
			}
			else
				i++;
		}
		
		return swaps;
	}
	
	static int i =  0; 
	
	static void inorder(Node root, List<Element> list)
	{
		if(root != null)
		{
			inorder(root.left, list);
			list.add(new Element(root.data, i++));
			inorder(root.right, list);
		}
	}
	
	public static void main(String[] args)
	{
		  Node root = new Node(5);
		  Node r2 = new Node(6);
		  Node r3 = new Node(7);
		  Node r4 = new Node(8);
		  Node r5 = new Node(9);
		  Node r6 = new Node(10);
		  Node r7 = new Node(11);
		

		  root.left = r2;
		  root.right = r3;
		  r2.left = r4;
		  r2.right = r5;
		  r3.left = r6;
		  r3.right = r7;
		 		  
		  out.println(minSwaps(root));
	}
}
