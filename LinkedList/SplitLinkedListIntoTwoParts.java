// splitting linkedlist into two parts
// if number of nodes is even keep one node more
// in one list

import static java.lang.System.*;

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
public class SplitLinkedListIntoTwoParts
{

	static Node insertNode(int data, Node head)
	{
		Node temp, ptr;
		temp = new Node(data);
		if(head == null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
			{
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
		return temp;
	}
	
	static void displayList(Node head, Node temp)
	{
		Node ptr = head;
		do
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}while(ptr != temp);
	}
	
   static void solve(Node head)
   {
	   Node p1 = head;
	   Node p2 = head;
	   Node newHead = null;
	   
	   while(true)
	   {
		   p1 = p1.next;
		   p2 = p2.next.next;
		   if(p2.next == head || p2 == head)
		   {
			   newHead = p1;
			   break;
		   }
	   }
	   
	   displayList(head, newHead);
	   out.println();
	   displayList(newHead, head);
   }
  
 
    public static void main(String [] args)
	{
	  Node head = null;
	  head = insertNode(1, head);
	  insertNode(9, head);
	  insertNode(3, head);
	  insertNode(12, head);
	  insertNode(4, head);
	  insertNode(45, head);
	  insertNode(85, head);
	  insertNode(63, head);
	  Node x = insertNode(6, head);
	 
	   x.next = head;
	 
	  displayList(head, head);
	  out.println();
	  solve(head);
	}
}
