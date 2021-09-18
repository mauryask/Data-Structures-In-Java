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

public class ReverseListInaGroupOfk 
{
	static Node head = null;
	
	static void insertNode(int data)
	{
		Node temp = null, ptr = null;
		temp = new Node(data);
		if(head  == null)
			head = temp;
		else
		{
			ptr = head;
			while(ptr.next != null)
			  ptr = ptr.next;
		  ptr.next = temp;
		}
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
	
	static void reverseList(int k)
	{
		Node temp =  new Node(-1); 
		Node cur = head;
		Node prev = temp;
		
		while(cur != null)
		{
			Node tail = cur;
			int count = 0;
			while(cur != null && count<k)
			{
				cur = cur.next;
				count++;
			}
			
			prev.next = reverseUtil(tail, k);
			prev = tail;
		}
		
	   printList(temp.next);
	}
	
	static Node reverseUtil(Node head, int k)
	{	
		Node prev = null, ptr = head, nextPtr = null;
		while(ptr != null && k-->0)
		{
			nextPtr = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = nextPtr;
		}
		
		return prev;
	}
	
/*============== Method-2 ================*/		
	/*
	* T(n) : O(n)
	* S(n) : O(n) : as Stack
	*/
	static void reverseList2(int k)
	{
		Node current  = head;
		Node newHead = null;
		int count = 0;
		Stack<Node> stack = new Stack<>();
	    Node tail = null;
		Node prev = null;
		
		while(current != null)
		{
			count = 0;
			
			while(current != null && count < k)
			{   
				/*
				* This variable helps to set head of the 
				* new linkedlists for the first time
				* It is only needed during the 
				* first iteration
				* and then it is useless
				*/
		        prev = current;
				/*
				* Push the k nodes in the stack every time 
				*/
				stack.push(current);
				/*
				* Update the current pointer
				*/
				current = current.next;
				count++;
			}
			
			/*
			* Set the head of the new linkedlist for 
			* for the first time
			*/
			if(newHead == null)
				newHead = prev;
			/*
			* Tail points to last node of each Linked list 
			* of size k
			*/
			tail = reverseListUtil2(stack, tail);
		}
		
		printList(newHead);
	}
	
	static Node reverseListUtil2(Stack<Node> stack,
	Node tail)
	{
		while(!stack.isEmpty())
		{
			/*
			* Set the tail to poin the first node initially
			*/
			if(tail == null)
				tail = stack.pop();
			else
			{
				/*
				* Add th popped node after tail 
				* and update the tail
				*/
			    Node temp = stack.pop();
				tail.next = temp;
				tail = temp;	
			}
		}
		
		/*
		* Returning tail of the reversed linked list
		*/
		return tail;
	}
	
	
	public static void main(String [] args)
	{
		insertNode(10);
		insertNode(23);
		insertNode(52);
		insertNode(89);
		insertNode(59);
		insertNode(31);
		insertNode(34);
		insertNode(45);
		insertNode(25);
		insertNode(47);
		
		printList(head);
		reverseList(3);
		//reverseList2(3);
	}
}