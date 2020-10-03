// checking if list is palindrome or not
// Time complexity : O(n)

class Node 
{
	int data;
	Node next;
	Node(int value)
	{
		data = value;
		next = null;
	}
}

public class CheckIfLinkedListPalindrome
{
	static Node insertNode(int value, Node head)
	{
		Node temp, ptr = null;
		temp = new Node(value);
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
	
///==============================================>> Main Method
   	
	public static void main(String [] args)
	{
		Node head = null;
		
	    head = insertNode(78, head);
		insertNode(56, head);
		insertNode(60, head);
		insertNode(50, head);
		//insertNode(50, head);
		insertNode(60, head);   
		insertNode(56, head);   
		Node end = insertNode(78, head); 
       
	   
	     if(new Solver().findMidNode(head))
              System.out.println("Plaindrome");
           else
			System.out.println("Not Paindrome");
	}
}

class Solver
{
	
  public boolean findMidNode(Node head)
   {
	   Node p1 = head;
	   Node p2 = head;
	   Node newHead = null;
	   Node temp = null;
	   while(p2!= null && p2.next != null)
	   {
		       temp = p1;
			   p1 = p1.next;
			   p2 = p2.next.next;
	   }
	   
	   Node head2 = reverseList(p1);
	   return isPalin(head, head2);
    }


  public Node reverseList(Node head)
	  {
		 Node ptr = head; 
		 Node prevPtr = null;
		 Node nextPtr = null;
		 
		 while(ptr!=null)
		 {
			 nextPtr = ptr.next;
			 ptr.next = prevPtr;
			 prevPtr = ptr;
			 ptr = nextPtr;
		 }
		 
		 return prevPtr;
	  }
	

    static boolean isPalin(Node head, Node head2)
	{
		while(head2 != null )
		{
			if(head.data != head2.data)
				return false;
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}	
}	

