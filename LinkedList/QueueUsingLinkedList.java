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

public class QueueUsingLinkedList
{
	static Node front = null, rear = null;
	
	static void enQueue(int data)
	{
		Node temp =  new Node(data);
		if(front == null)
			rear = front = temp;
		else
		{
			rear.next = temp;
			rear = temp;
		}
	}
	
	static Node deQueue()
	{
		//Handling underflow condition	
		if(front == null)
			return new Node(-1);
		
	    Node temp = front, ptr = front.next;
		front.next = null;
		front = ptr;
		return temp;
	}
	
	public static void main(String [] args)
	{
		enQueue(12);
		enQueue(5);
		enQueue(23);
		enQueue(85);
		enQueue(41);
		enQueue(96);
		
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
		out.println(deQueue().data);
	}
}

