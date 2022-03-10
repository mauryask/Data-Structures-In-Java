/*
* T(n) : O(n) 
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class SolveInfixExpression 
{	
   static int solveExp(String exp)
   {
	   // contains operands
	   Stack<Character> operator = new Stack<>();
	   // contains operators
	   Stack<Integer> operand = new Stack<>();
	    		   
	   for(int i=0; i<exp.length(); i++)
	   {
		 char ch = exp.charAt(i);
		  
		 if(ch == '(')
			 operator.push(ch);
		 else if(Character.isDigit(ch))
			 operand.push(ch-'0');
		 else if(ch == ')')
		 {
			 // if closing bracket encountered 
			 // perform below operation until 
			 // opening bracket encountered
			 while(operator.peek() != '(')
			 {
				 char optr = operator.pop();
				 int a = operand.pop();
				 int b = operand.pop();
				 
				 int opr = operation(a, b, optr);
				 
				 operand.push(opr);
			 }
			 
			 // remove opening bracket
			 operator.pop();
		 }
		 else
		 {
			 // if the ch is a mathematical operator
			 // do the following operation
		    	while(
				!operator.isEmpty() 
				&& operator.peek() != '('
				&& precedence(ch) <= precedence(operator.peek())) 
				{
				  char optr = operator.pop();
				  int a = operand.pop();
				  int b = operand.pop();
				 
				  int opr = operation(a, b, optr);
				 
				  operand.push(opr);
				}
				// push the current operator
             operator.push(ch);				
		 }
	   }

     // process the rest of the operators
	 // in the stack
	  while(!operator.isEmpty())
	  {
		 char optr = operator.pop();
		 int a = operand.pop();
		 int b = operand.pop();
				 
		 int opr = operation(a, b, optr);
				 
		 operand.push(opr);		  
	  }	 
     // peek of operand stack is going
	 // to have the solution to the expression
     return operand.pop();	  
   }
   
   // perform operations from b to a
   static int operation(int a,int b, char optr)
   {
	   if(optr == '+')
		   return b+a;
	   else if(optr == '-')
		   return b-a;
	   else if(optr == '*')
		   return b*a;
	   else 
		   return b/a;
   }
   
   // get precedence of the operators
   static int precedence(char optr)
   {
	   if(optr == '+' || optr == '-')
		   return 0;
	   return 1;
   }
   

	public static void main(String [] args)
	{
		String exp = "2+(5-3*6/2)";
		out.println(solveExp(exp));
	}
}