/**
Time complexity: O(n+m)
Space complexity: O(1)
*/

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

public class MergingTwoSortedLInkedLists 
{
	static Node tail = null;
	
	static Node insertNode(Node head, int data)
	{
	   Node temp, ptr;
		temp = new Node(data);
		if(head == null)
		{
			head = temp;
			tail = temp;
			return head;
		}
          
        tail.next = temp;
		tail = temp;		
		 
		return temp;
	}
	
	static  Node mergeLists(Node head1, Node head2)
	{
		Node s = null;
		Node head;
		if(head1.data <= head2.data)
		{
			s = head1;
			head1 = s.next;
		}
		else
		{
			s = head2;
			head2 = s.next;
		}
		
		head = s;
		
		
	while(head1 != null && head2 != null)
	{
	  if(head1.data <= head2.data)
	  {
		  s.next = head1;
		  s = head1;
		  head1 = s.next;
	  }
	  else
	  {
		 s.next = head2;
		 s = head2;
		 head2 = s.next;
	  }
	}
	
    if(head1 == null)
		s.next = head2;
    else if(head2 == null)
		s.next = head1;
	return head;
}
	
	static void printList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	public static void main(String [] args)
	{
	   Node head1 = null;
	   Node head2 = null;
       head1 = insertNode(head1,10);
        insertNode(head1,12);	   
        insertNode(head1,20);	   
        insertNode(head1,45);	   
        insertNode(head1,63);	   
        insertNode(head1,74);
        insertNode(head1,78);
        insertNode(head1,80);
        insertNode(head1,96);

       head2 = insertNode(head2, 2);
	    insertNode(head2,35);
	    insertNode(head2,33);
	    insertNode(head2,47);
	    insertNode(head2,50);
	    insertNode(head2,87);
	   
	   Node head = mergeLists(head1, head2);
	   printList(head);
	}
}