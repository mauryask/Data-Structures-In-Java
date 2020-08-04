// This is the most optimal solution
// Time complexity : O(n)

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

public class FindMergePointOfTwoLinkedLists 
{
	static Node insertNode(Node head,int value)
	{
		Node ptr, temp;
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
	
	static void printList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	  static Node findMergePoint(Node head1, Node head2)
	  {
		  int l1 = findLength(head1);
		  int l2 = findLength(head2);
		  int d = Math.abs(l1-l2);
		  
		  Node p, q;
		  p = head1;
		  q = head2;
		  
		  if(l1 > l2)
		  {
			 for(int i=1; i<=d; i++)
			 {
				 p = p.next;
			 }
		  }
		  else
		  {
			 for(int i=1; i<=d; i++)
			 {
				 q = q.next;
			 }  
		  }
		  
		  while(p!=q)
		  {
			  p = p.next;
			  q = q.next;
		  }
		  
		  return p;
	  }
	
	static int findLength(Node head)
	{
		int count=0;
		while(head != null)
		{
			count++;
			head = head.next;
		}
		return count;
	}
	
	public static void main(String [] args)
	{
	   Node head1 = null;
	   Node head2 = null;
       head1 = insertNode(head1,10);
       Node n1 = insertNode(head1,45);	   
       Node n2 = insertNode(head1,12);	   
       Node n3 = insertNode(head1,89);	   
       Node n4 = insertNode(head1,63);	   
       Node n5 = insertNode(head1,74);
       Node n6 = insertNode(head1,20);
       Node n7 = insertNode(head1,78);
       Node n8 = insertNode(head1,96);

       head2 = insertNode(head2, 25);
	   Node m1 = insertNode(head2,2);
	   Node m2 = insertNode(head2,47);
	   Node m3 = insertNode(head2,33);
	   Node m4 = insertNode(head2,35);
	   Node m5 = insertNode(head2,44);
	   
	   //merging two linked list for testing
	   m5.next =  n5;
	   
	   //printList(head2);
	   Node mp = findMergePoint(head1, head2);
	   System.out.println(mp.data);
	}
}