/*
** Bubble Sort 
***************
* Time complexity: O(n*n)
* Space complexity: O(1)
*/
import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

public class BubbleSort
{
	// sort by swapping data only
   	static void sort(Node head)
	{
		Node ptr = null, tail = null;
		
		while(head != tail) 
		{
			ptr = head;			
			while(ptr.next != tail)
			{
			   if(ptr.data > ptr.next.data)
			   {
				   int data = ptr.data;
				   ptr.data = ptr.next.data;
				   ptr.next.data = data;
			   }
               ptr = ptr.next;			   
			}			
			tail = ptr;		
		}	
	}
	
	//sort by swapping nodes 	
	static Node deepSort(Node head)
	{
		Node ptr =  null, tail = null, prev = null;
		// optimization
		boolean isSwapped = true;
		
		while(head != tail)
		{
			ptr = head;
			prev = null;
			isSwapped = false;
			
			while(ptr.next != tail)
			{
				if(ptr.data > ptr.next.data)
				{
			     	ptr = swap(ptr);
					
					// if head is greater than the 
					// the head.next
					// update head after swap
					if(prev == null)
					   head = ptr;
					else
					   prev.next = ptr;	
				   isSwapped = true;
				}
				
			    prev = ptr;
		        ptr = ptr.next;
			}	
			 tail = ptr;
			 
            if(!isSwapped)
              break;				
		}
		
		return head;
	}
	
	static Node swap(Node head)
	{
		Node p1 = head;
		Node p2 = head.next;	
		Node temp = p2.next;
		p2.next = p1;
		p1.next = temp;
        return p2;
	}
	
	static void printList(Node head)
	{
		Node ptr = head;
		
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		out.println();
	}
	
	public static void main (String[] args)
	{
		Node head = new Node(10);
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(16);
		Node n4 = new Node(11);
		Node n5 = new Node(80);
		Node n6 = new Node(52);
		Node n7 = new Node(50);
		Node n8 = new Node(45);
		Node n9 = new Node(39);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		printList(head);
		//sort(head);
		head = deepSort(head);
        printList(head);
		
	}
}

