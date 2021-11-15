import static java.lang.System.*;

public class FindMidArrayImplementation
{
	int top = -1;
	int mid = -1;
	int max = 5;
	int stack[] = new int[max];
	
	// O(1)
	static void push(int x)
	{
		// stack overflow
		if(top == max-1)
			return;
		
		// if only one element 
		// it is itself going to be mid
        if(top == -1)
        	mid++;
		top++;
		stack[top] = x;
		
		if(top %2 != 0)
			mid++;
	}
	
	// O(1)
	static int pop(int x)
	{
		// stack underflow
	   if(top == -1)
		return -1;
		
		int data = stack[top];
		top--;
		// even index == odd number of elements 
		// decrease mid by one
		if(top % 2 == 0)
			mid--;
		return data;		
	}
	
	// O(1)
	static int getMid()
	{
		//stack underflow
		if(top == -1)
			return -1;
		else // if stack is not empty
			return A[mid];
	}
	
	/*
	* Here deleteMid() can not be achieved 
	* in O(1), since after deletetion 
	* each element will be shifted
	* downward direction by one position
	*/
	
	static void deleteMid()
	{
		
	}
	
	public static void main(String [] args)
	{
		
	}
}