public class Stack 
{
	static int top = -1;
	static int max = 5;
	static int stack[] = new int[max];
	public static void main(String [] args)
	{
		push();	
		push();	
		push();	
		push();
        System.out.println("\nDisplaying teh elements");	
        display();		
		pop();
		System.out.println("The elements after poping!");
		display();
		peak();
	}
	
	static void push()
	{
		if(top == max)
		{
			System.out.println("Overflow!");
			return;
		}
		else
		{
			top++;
			System.out.print("\nenter the element: ");
			stack[top] = new java.util.Scanner(System.in).nextInt(); 
		}
	}
	
	static void pop()
	{
		if(top==-1)
		{
			System.out.println("Undeflow!");
			return;
		}
		else
		{
			System.out.println("The element "+stack[top]+" removed");
			top--;
		}		
	}
	
	static void display()
	{
		if(top==-1)
		{
		   System.out.println("The stack is empty!");
		   return;
	    }
		else
		{
			for(int i=top; i>=0; i--)
			{
				System.out.print(stack[i]+"  ");
			}
		}
	}
	
	static void peak() //printing the top element without deleting it
	{
	   if(top==-1)
	   {
		   System.out.println("The stack is empty!");
		   return;
	   }		  
		else
		{
			System.out.println("Thr top element is: "+ stack[top]);
		}	
	}
}