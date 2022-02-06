/**
Time complexity: O(m+n)
Space complexity : O(m+n) 
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
	   next =  null;
	}
}

public class FindMergePointOfTwoLinkedListsUsingStack
{
	 static Node tail = null;
	
	 static Node insertNode(Node head,int data)
	 {
		 Node temp = new Node(data);
		 Node ptr = null;
		 
		if(head.next == null)
			tail = head;
		
        tail.next = temp;
        tail = temp;
		
		return tail;
	 }
	 
	 static void displayList(Node head)
	 {
		 Node ptr = head;
		 
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 
		 out.println();
	 }
	 
	 static Node findMergePoint(Node head1, Node head2)
	 {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
	
	     
		while(head1 != null)
		{
			st1.push(head1);
			head1 = head1.next;
		}			
	
	    while(head2 != null)
		{
			st2.push(head2);
			head2 = head2.next;
		}	
	   
	    Node temp = null;
		
	    while(!st1.isEmpty() && !st2.isEmpty())
		{
		   Node p1 = st1.pop();
		     
		   if(p1 != st2.pop())
			 return temp;
		 
           temp = p1;
		}
		
		return null;
	 }
			
	public static void main(String [] args) 
	{
		Node head1 = new Node(5);
		Node f1 = insertNode(head1, 10);
		Node f2 = insertNode(head1, 12);
		Node f3 = insertNode(head1, 14);
		Node f4 = insertNode(head1, 28);
		
		Node head2 =  new Node(78);
		Node s1 = insertNode(head2, 55);
		Node s2 = insertNode(head2, 96);
		Node s3 = insertNode(head2, 10);
		Node s4 = insertNode(head2, 23);
		Node s5 = insertNode(head2, 45);
		Node s6 = insertNode(head2, 102);
		Node s7 = insertNode(head2, 56);
		
		f4.next = s4;
		
		displayList(head1);
		displayList(head2);
		Node mNode = findMergePoint(head1, head2);
		out.println(mNode != null ? mNode.data : "No merge point found");
	}
}