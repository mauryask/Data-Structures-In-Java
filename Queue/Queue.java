//array implementaion of the queue
import java.util.Scanner;
import static java.lang.System.*;

public class Queue 
{
	static int rear = -1;
	static int front = -1;
	static final int max = 4;
	static int queue[] = new int[max];
	
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n;
		do{
			out.println("\n\n********Main Menu*******\n");
			out.println("(A)press 1 to insert!");
			out.println("(B)press 2 to display!");
			out.println("(C)press 3 to delete!");
			out.println("(D)press 4 to exit!");
			
			out.print("Enter your choice: ");
		    n = sc.nextInt();
			switch(n)
			{
				case 1: 
				enqueue();
				break;
				case 2:
				display();
				break;
				case 3:
				dequeue();
				break;
				case 4: 
				System.exit(0);
				break;
				default:
				out.println("Please enter a write choice!");
			}
		}while(n!=4);
	}
	
	static void enqueue()
	{
		if(rear ==  max-1)
		{
			out.println("Overflow!");
			return;
		}
		
		if(rear ==-1 && front== -1)
		{
			rear++;
			front++;
		}
		else 
			rear++;
		
		out.print("Enter element: ");
		int x = new Scanner(System.in).nextInt();
		queue[rear] = x;			
	}
	
	static void display()
	{
	   if(front == -1 || front>rear)
	   {
		   out.println("The queue is empty!");
		   return;
	   }
	   else
	   {
		 for(int i =  front; i<= rear; i++)
				out.print(queue[i]+"\t");
	   }
	}
	
	static void dequeue()
	{
		int y;
		if(front==-1 ||  front> rear)
		{
			out.println("Underflow!");
			return;
		}
		else
		{
			y = queue[front];
			if(front == rear)
			{
				front = -1;
				rear = -1;
			}
			else
			{
				front++;
			}
		}
		
		out.println("element "+ y+" removed!");
	}
}