import static java.lang.System.*;

class Node 
{
	int value;
	Node next;
	
	public Node(int value)
	{
		this.value= value;
	}
}

public class LinkedQueue
{
	static Node front = null;
	static Node rear = null;
		
	static void enqueue(int value)
	{
		Node temp = new Node(value);

		if(front == null){
			front = temp;			
		}else{
			rear.next = temp;		
		}

		rear = temp;
	}
		
	static int deque()
	{
		if(front == null){
			out.println("Underflow!!");
			return -1; 
		}

		int key = front.value;

		Node temp = front;
		front = front.next;
		temp.next = null;

		return key;
	}
	
	public static void main(String [] args)
	{
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		out.println(deque());	
		out.println(deque());	
		out.println(deque());	
		out.println(deque());	
		out.println(deque());	
		enqueue(56);
		out.println(deque());
	}
}