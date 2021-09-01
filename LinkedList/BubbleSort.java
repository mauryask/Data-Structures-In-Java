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
   	static void sort(Node head)
	{
		Node p1 = null;
		Node p2 = null;
		Node temp = null;
		
		do
		{		
		    // in first iteration thismloop is not
			// going to be executed since (p2 = temp)
			while(p2 != temp)
			{ 
				if(p1.data > p2.data)
				{
					int val = p1.data;
					p1.data = p2.data;
					p2.data = val;
				}
				
				p1 = p2;
				p2 = p2.next;			
			}
		
			temp = p1;
			
			p1= head;
			p2 = head.next;
			
		}while(p2 != temp);
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
		Node head = new Node(50);
		//Node n1 = new Node(20);
		/*Node n2 = new Node(8);
		Node n3 = new Node(10);
		Node n4 = new Node(12);
		Node n5 = new Node(80);
		Node n6 = new Node(52);
		Node n7 = new Node(50);
		Node n8 = new Node(45);
		Node n9 = new Node(39);*/
		
		//head.next = n1;
		/*n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;*/
		
		printList(head);
		sort(head);
        printList(head);
		
	}
}

