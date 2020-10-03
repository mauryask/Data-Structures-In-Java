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
public class SortLinkedList
{
	static Node head = null;
	static void insertNode(int data)
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
	}
	
	static void displayList()
	{
		Node ptr = head;
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
	}
	
   static void sort()
   {
	   Node p1 = head, p2 = head.next, temp = null;
	   boolean isSwapped;
	   
	   while(p1 != temp)
	   {
		   isSwapped = false;
		   while(p2 != temp)
		   {
			   if(p1.data > p2.data)
			   {
				   int dummy = p1.data;
				   p1.data = p2.data;
				   p2.data = dummy;
				   isSwapped = true;
			   }
			   
			     p1 = p1.next;
				 p2 = p2.next;
		   }
		
  		if(!isSwapped)
			   break;
		   
		   temp = p1;
		   p1 = head;
		   p2 = head.next;
	   }
	   
	   displayList();
   }
  
 
    public static void main(String [] args)
	{
	  insertNode(1);
	  insertNode(9);
	  insertNode(3);
	  insertNode(12);
	  insertNode(4);
	  insertNode(6);
	 
	  displayList();
	  out.println();
	  sort();
	}
}
