/**

Time complexity:
push : O(1)
pop: O(1)
Space complexity: O(n)

*/

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

public class StackUsingLinkedList
{
	 static Node top = null;
	
     // push operation
	 static void push(int data)
	 {
		 Node temp = new Node(data);
		 
		 // check for overflow
		 // if computer memory is completely full
		 if(temp == null)
		 {
			 out.println("\nOverflow!");
			 return;
		 }
		 
		 temp.next = top;
		 top = temp;
	 }
	 
	 // pop operation
	 static void pop()
	 {
		 // check for underflow
		 if(isEmpty())
		 {
			 out.println("\nUnderflow!");
			 return;
		 }
		 
		 out.println("\npop: "+ top.data);
		 
		 Node ptr = top.next;
		 top.next = null;
		 top = ptr;
	 }
	 
	 // get top element
	 static int peek()
	 {
		// check for underflow
		if(isEmpty())
		{
			out.println("\nUnderflow!");
			return -1;
		}
		
		return top.data;
	 }
     
	 // check if stack is empty
	 static boolean isEmpty()
	 {
		 return top == null;
	 }
	 
	 
	 // display the stack
	 static void display()
	 {
		 if(isEmpty())
		 {
			 out.println("\nUnderflow!");
			 return;
		 }
		 
		 Node ptr = top;
		 
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 out.println();
	 }
	 
	 // main method
	public static void main(String [] args) 
	{
	   push(10);
	   push(7);
	   push(9);
	   push(6);
	   push(5);
	   display();
	   pop();
	}
}