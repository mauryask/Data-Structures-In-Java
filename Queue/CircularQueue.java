//array implementation of the circular queue

public class CircularQueue
{
	static int rear = -1;
	static int front = -1;
	static int max  = 3;
	static int queue[] = new int[max];
	
	static void enQueue()
	{
		if((rear+1)%max == front)
		{
			System.out.println("Overflow!");
			System.exit(1);
		}
		else 
		{
			if(rear==-1 && front==-1)
			{
				rear = front  = 0;
			}
			else if(rear == max-1 && front!=0)
			{
				rear = 0;
			}
			else
				rear = (rear+1)%max;
			
			System.out.print("Enter the element: ");
			int x = new java.util.Scanner(System.in).nextInt();
			queue[rear] = x;
		}
	}
	
	
	static void deQueue()
	{
		int value;
		if(front==-1)
		{
			System.out.println("Underflow!");
			System.exit(1);
		}
		else
		{
			value = queue[front];
			if(front==rear) //when theer is only one element
				front=rear=-1;
			else if(front == max-1)
			{
				front = 0;
			}
			else
				front++;
			
			System.out.println("The element: "+value+" is removed!");
		}
	}
	
	static void display()
	{
		if(front==-1)
		{
			System.out.println("Underflow!");
			System.exit(1);
		}
		else
		{
		for(int i=front; i<=rear; i++)
		{
			System.out.print(queue[i]+"  ");
		}
	}
	}
	
	public static void main(String [] args)
	{
	 enQueue();
	 enQueue();
	 enQueue();
	 enQueue();
	 
	 display();
     System.out.println("\nDeque and display!");
	 deQueue();
	 deQueue();
	 display();
	 
	}
	
}