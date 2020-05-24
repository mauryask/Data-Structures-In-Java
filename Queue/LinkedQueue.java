//linkedlist representaion of the queue
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
	static Node front;
	static Node rear;
	
	static Node createNode(int value)
	{
		Node newNode = new Node(value);
		return newNode;
	}
	
	static void enqueue(int value)
	{
		Node temp = createNode(value);
		if(front==null && rear==null)
		{
			front = temp;
			rear = temp;
		}
		else
		{
			rear.next = temp;
			rear = temp;
		}
	}
	
	
	static void dequeue()
	{
		int value=0;
		if(front==null)
		{
			System.out.println("Underflow!");
			return;
		}
		else 
		{
		  value = front.value;
		  if(front == rear)
		  {
			 front = rear = null; 
		  }
		  else
		  {
		   front = front.next;
		  }
		}
		
		System.out.println("The element "+value+" is removed!");
	}
	
	static void display()
	{
		Node temp = front;
		if(front==null)
		{
			System.out.println("Underflow!");
			System.exit(1);
		}
		while(temp!=null)
		{
			System.out.print(temp.value+"  ");
			temp = temp.next;
		}
	}
	
	public static void main(String [] args)
	{
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		display();
		System.out.println();
		dequeue();
		dequeue();
		dequeue();
		dequeue();
		dequeue();
		display();
		
	}
}