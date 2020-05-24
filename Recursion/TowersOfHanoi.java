//https://www.youtube.com/watch?v=q6RicK1FCUs
//this video gives the best explanation for 'TowersOfHanoi' problem
package com.pnstech;

public class TowersOfHanoi {

	public static void main(String[] args) {
		
    towersOfHanoi(3,'A','B','C'); //three discs and three towers -> A, B and C
		
	}
	
   static void towersOfHanoi(int n, char A, char B, char C)
	{
		if(n>0)
	       {
		       towersOfHanoi(n-1, A, C, B);
		       System.out.println("move a disc from "+A+" to "+C);
		       towersOfHanoi(n-1, B, A, C);
		   }
	}

}
