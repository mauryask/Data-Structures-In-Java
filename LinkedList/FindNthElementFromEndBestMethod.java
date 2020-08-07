//this program demonstrates finding the nth node 
//this is the best way to do this
//this is more time effcient than other methods
//Time Complexty : O(n)

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

public class FindNthElementFromEndBestMethod
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
		Node ptr1, ptr2;
		ptr1 = ptr2 = head;
		//moving the first point ptr1 at 
		//nth position from the begining
		
		int count = 1;
		while(count != n && ptr1.next != null)
		{
			count++;
			ptr1 = ptr1.next;
		}
		
		if(count==n) //check if there is sug=fficient number of nodes
		{
			//from this point move both pointes simultaneously
			while(ptr1.next != null)
			{
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			System.out.println("\n"+n+"th node from the end is: "+ptr2.value);
		}
		else
			System.out.println("\nThere are fewer nodes");
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
		findNthNodeFromEnd(6);
	}
}
