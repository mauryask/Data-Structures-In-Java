//this program demonstrates finding the nth node 
//from the end of the list in O(n) time
//usong hash table 

import java.util.HashMap;
class Node 
{
	int value;
	Node next;
	Node(int value)
	{
		this.value = value;
		next = null;
	}
}

public class FindNthNodeFromEnd
{
	static Node head = null;
	static void insertNode(int value)
	{
		Node ptr,temp;
		temp = new Node(value);
		if(head == null)
		{
			head = temp;
		}
		else
		{
			ptr = head;
			while(ptr.next!= null)
			{
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
	}
	
	static void displayNode()
	{
		Node ptr = head;
		while(ptr!= null)
		{
			System.out.print(ptr.value+" ");
			ptr = ptr.next;
		}
	}
	
	static void findNthNodeFromEnd(int n)
	{
		HashMap<Integer,Node> map = new HashMap<>();
		Node ptr = head;
		int i=0;
		while(ptr!=null)
		{
			map.put(++i,ptr);
			ptr = ptr.next;
		}
		
		//position of the node from the start = (total nodes - position from end + 1)
		int start_pos = i-n+1; 
		System.out.println("\nThe"+n+"th Node from the ebd is: "+map.get(start_pos).value);
	}
	
    public static void main(String [] args)
	{
		insertNode(10);
		insertNode(23);
		insertNode(54);
		insertNode(13);
		insertNode(14);
		insertNode(45);
		insertNode(96);
		insertNode(78);
		
		displayNode();
		findNthNodeFromEnd(2);
	}
}