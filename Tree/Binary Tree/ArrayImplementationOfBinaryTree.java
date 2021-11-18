import static java.lang.System.*;
import java.util.*;

public class ArrayImplementationOfBinaryTree
{
	static void setRoot(int A[],int key)
	{
		// check if root is not yet set
		if(A[0] == -1)
		    A[0] = key;
		else
			System.out.println("root is already present..");
	}
	
	static void setLeftChild(int A[], int rootIndex , int key)
	{
		int leftIndex = 2 * rootIndex + 1;
		if(A[leftIndex] == -1)
			A[leftIndex] = key;
		else
			System.out.println("already have a left child..");
	}
	
	static void setRightChild(int A[], int rootIndex, int key)
	{
		int rightIndex =  2 * rootIndex + 2;
		if(A[rightIndex] == -1)
			A[rightIndex] = key;
		else
			System.out.println("already have a right child..");
	}
	
	static void printTree(int A[])
	{
		for(int i=0; i< A.length; i++)
		{
			System.out.print(A[i]+" ");
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = new int[10];
		Arrays.fill(A, -1);
		setRoot(A, 10);
		setLeftChild(A,0,78);
		setRightChild(A,0,15);
		setLeftChild(A,2,20);
		setRightChild(A,2,35);
		
		printTree(A);
	}
}