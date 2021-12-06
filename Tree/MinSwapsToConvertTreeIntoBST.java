/*
* Here the concept is same as
* finding minimum number of swaps to 
* to sort the array
* T(n) : O(n log n)
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
		  Node root = new Node(3);
		  Node r2 = new Node(12);
		  Node r3 = new Node(2);
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
		  
		  out.println(minSwaps(root));
	}
}
