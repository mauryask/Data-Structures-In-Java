//linkedlist implementation of the Stack

class Node
{
	int value;
	Node next;
	
	public Node(int value)
	{
		this.value= value;
	}
}


public class LinkedStack
{
	static Node top = null;
	static Node head = null;

	static Node createNode(int value)
	{
		Node temp;
		temp = new Node(value);
		return temp;
	}
	
	static void push(int value)
	{
		Node temp = createNode(value);
		if(top==null)
		{
			top = temp;
			head = temp;
		}
		else
		{
			top.next = temp;
			top = temp;
		}
	}
	
	static void pop()
	{
		if(top == null)
		{
			System.out.println("Underflow!");
			return;
		}
		else
		{
		   Node temp = head;
		   while(temp.next != top)
			   temp = temp.next;
		   
		   System.out.println("\nThe element "+ top.value+" is poped!");
		   
		   temp.next = null;
		   top = temp;
		}
	}
	
	static void peak()
	{
       if(top==null)
	   {
		   System.out.println("Undeflow!");
		   return;
	   }
	   else
	   {
		   System.out.println("The top element is: "+ top.value);
	   }
	}
	
	static void display()
	{
		if(top==null)
		{
			System.out.println("Underflow!");
		}
		else
		{
			Node temp = head;
			while(temp!=null)
			{
				System.out.print(temp.value+" ");
				temp = temp.next;
			}
		}
	}
	
	public static void main(String [] args)
	{
	   push(10);	
	   push(20);	
	   push(30);	
	   push(40);
       System.out.println("\ndisplaying element!");	
       display();
        pop();
	          System.out.println("\ndisplaying element after pop!");	
			   display();
			   System.out.println();
			   peak();
			   
	}
}