//This program demonstrates finding the mergepoint of two linkedlkists
//using the hashtable
// Time complexity : O(n+m)
//space complexity : O(m+n)

import java.util.Stack;

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

public class FindMergePointOfTwoLinkedListsUsingStack 
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
		Node p1 = head1;
		Node p2 = head2;
		
		Stack<Node> s1 =  new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		//push all the nodes of first list into first stack
		while(p1!=null)
		{
			s1.push(p1);	
			p1 = p1.next;
		}
		
		//push all the nodes of second list into first stack
		while(p2!=null)
		{
			s2.push(p2);	
			p2 = p2.next;
		}
		
		// now pop top of the both lists one by one and compare
		// if they are equal put it in a temporray variable
		// else return temp 
		
		Node temp =  null;
		
		while(!s1.isEmpty()&& !s2.isEmpty())
		{
			Node n1  = s1.pop();
			Node n2 = s2.pop();
						
			if(n1 == n2)
				temp = n1;
            else if(n1 != n2)
                return temp;				
		}
		
		return null;
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
	   if(mp == null)
		   System.out.println("There is no merge point");
	   else
	       System.out.println(mp.data);
	}
}