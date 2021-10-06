/*
* T(n) : O(1)
* S(n) : O(1)
*/

import static java.lang.System.*;
import java.util.*;

public class ImplementingTwoStacks
{	
      static int max = 10;
	  static int top1 = -1;
	  static int top2 = max;
	  
	  static int stack[] = new int[max];
	  
      static void push1(int x)
	  {
		  if(top2 ==  top1 + 1)
		  {
			  out.println("Stack overflow!!");
			  return;
		  }
		  
		  top1++;
		  stack[top1] = x;
	  }
	  
	  static void push2(int x)
	  {
		 if(top2 ==  top1 + 1)
		  {
			  out.println("Stack overflow!!");
			  return;
		  }
		  
		  top2--;
		  stack[top2] = x;
	  }
	  
	  static int pop1()
	  {
		  if(top1 == -1)
			  return -1;
		  int data = stack[top1];
		  top1--;
		  return data;
	  }
	  
	  static int pop2()
	  {
		  if(top2 == max)
			  return -1;
		  int data = stack[top2];
		  top2++;
		  return data;
	  }
	  
		public static void main(String [] srga)
		{
			push1(10);
			push1(44);
			push1(52);
			push1(20);
			push1(15);
			push1(58);
			push1(36);
			push1(2);
			push1(14);
			
			push2(4);
			
			out.println(pop2());
			//push2(52);
			for(int x: stack)
				out.print(x+" ");
			out.println("\n"+top1+", "+top2);
		}	
}