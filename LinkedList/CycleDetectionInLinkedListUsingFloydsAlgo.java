/**
 Floyd's Tortoise and Hare Algorithm 
 Or simply Floyd's algorithm of cycle detection
 This is the best algorithm for cyclce detection
 Time Complexity  : O(n)
 Space Complexity : O(1)
 this is aloso known a memory less approach of loop detection
*/

import java.util.*;
import static java.lang.System.*;

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

public class Test 
{
	 static Node tail = null;
	
	 static Node insertNode(Node head, int data)
	 {
		 Node temp = new Node(data), ptr = null;
		 if(head == null)
			 head = temp;
		 else
			 tail.next = temp;
		 tail = temp;
		 return temp;
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
	 
	 static void isLoop(Node head)
	 {
		 Node slowPtr = head,  fastPtr = head;
		 boolean flag= false;
		 
		 while(fastPtr != null && fastPtr.next != null)
		 {
			 slowPtr = slowPtr.next;
			 fastPtr = fastPtr.next.next;
			 
			 if(slowPtr == fastPtr)
			 {
				 int loopLen = findLength(slowPtr, fastPtr);
				 flag = true;
				 Node loopNode  = findLoopNode(slowPtr, head);
				 out.println("loop length: "+ loopLen + "\nloop node: "+ loopNode.data);
				 return;
			 }
		 }
		 
		 if(!flag)
			 out.println("No loop found!");
	 }
	 
	 static int findLength(Node slowPtr, Node fastPtr)
	 {
	    	int count  = 0;
			
			do{
				count++;
				fastPtr = fastPtr.next;
			}while(slowPtr != fastPtr);
			
			return count;
	 }
	 
	 static Node findLoopNode(Node ptr, Node head)
	 {
		Node temp = head;
		
		while(temp != ptr)
		{
			temp = temp.next;
			ptr = ptr.next;
		}
		
		return temp;
	 }
	 
	public static void main(String [] args) 
	{
		Node head = null;
		head = insertNode(head, 13);
		Node r1 = insertNode(head, 5);
		Node r2 = insertNode(head, 12);
		Node r3 = insertNode(head, 20);
		Node r4 = insertNode(head, 32);
		Node r5 = insertNode(head, 24);
		
		// creating a loop
		r5.next = r3; 
		
        isLoop(head);
	}
}