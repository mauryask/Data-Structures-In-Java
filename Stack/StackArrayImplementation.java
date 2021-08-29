import static java.lang.System.*;

public class StackArrayImplementation
{
	/*top pointer of stack*/
	static int top = -1;
	/*max size of stack*/
	static int max = 5;
	static int stack[] = new int[max];
		
	static void push(int x)
	{
		/* Check if array if stack is completye full */
		if(top == max-1)
		{
			out.println("\n Stack Overflow!!");
			return;
		}
		else
		{
			top++;
			stack[top] = x;
		}
	}
	
	static int pop()
	{

		/*Check if stack is empty*/
		if(top == -1)
			return -1;
		else
		{
			int data = stack[top];
			top--;
			return data;
		}	
	}
	
	static void display()
	{
			for(int x : stack)
				out.print(x+" ");
	}
	
	static int peak() 
	{
	   if(top == -1)
		   return -1;
	   return stack[top];	
	}
	
	
	public static void main(String [] args)
	{
		push(5);	
		push(12);	
		push(25);	
		push(20);	
		push(15);	
		push(10);	
		out.println(pop());
		out.println(pop());
  	}
}