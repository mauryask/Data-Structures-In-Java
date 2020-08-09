//This program demonstrates finding the mergepoint of two linkedlkists
//using the hashtable
// Time complexity : O(n) + O(m)

import java.util.HashSet;

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

public class FindMergePointOfTwoLinkedListsUsingHashTable 
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
		 HashSet<Node> set = new HashSet<>();
		 Node p1,p2;
		 p1= head1;
		 p2 = head2;
		 
		 //add allt he nodes of the first list into the hash Table
		 while(p1!=null)
		 {
		    set.add(p1);
			p1 = p1.next;
		 }
		 
		 //now start scanning second list and check 
		 //if any node already present in the hash set
		 while(p2 != null)
		 {
			 if(set.contains(p2))
			   return p2;
		    
			 p2 = p2.next;
		 }
		 
		 return null;
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
	   if(mp == null)
		   System.out.println("There is no merge point");
	   else
	       System.out.println(mp.data);
	}
}
