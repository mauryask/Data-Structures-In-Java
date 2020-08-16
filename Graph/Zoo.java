import java.util.*;
public class Zoo 
{
	public static void main(String [] ags)
	{
		Scanner sc = new Scanner(System.in);
		
		
		int cost[] = new int[3];
		int maxArea[] = new int[3];
		int numAni[] = new int[3];
		int reqAre[] = new int[3];
		int totReqAre[] = new int[3];
		
		//cost per sqare inch
		cost[0] =  sc.nextInt();
		cost[1] =  sc.nextInt();
		cost[2] =  sc.nextInt();
	
	   //max area	   
	   maxArea[0] = sc.nextInt();
	   maxArea[1] = sc.nextInt();
	   maxArea[2] = sc.nextInt();
	   
	   // num and required area
	   numAni[0] = sc.nextInt();
	   reqAre[0] = sc.nextInt();
	   
	   numAni[1] = sc.nextInt();
	   reqAre[1] = sc.nextInt();
	   
	   numAni[2] = sc.nextInt();
	   reqAre[2] = sc.nextInt();
	   
	   int totalArea = sc.nextInt();
	   
	   sort(cost, maxArea, numAni, reqAre)
	   
	   int cSum = 0;
	   
	   //total area required for each
	   totReqAre[0] = numAni[0] * reqAre[0];
	   totReqAre[1] = numAni[1] * reqAre[1];
	   totReqAre[2] = numAni[2] * reqAre[2];
	   
       int remainAre = total - totReqAre[0];
        cSum =  totReqAre[0] * cost[0];

       int sumTwo = totReqAre[1]  +  totReqAre[2];  
	   if(sumTwo < remainAre)
	   {
		   cSum += cost[2] * maxArea[2];
           remainAre = total - (remainAre +	maxArea[2]);
           if(remainAre >= totReqAre[1])
		   {
			   cSum += cost[1] * remainAre; 
		   }
			else
			{
				cSum -= cost[2] * maxArea[2];
				remainAre = total + (remainAre +	maxArea[2]);
				
				cSum += cost[1] * totReqAre[1];
				remainAre = total - (remainAre + totReqAre[1])
				cSum += cost[2] * remainAre;
			}	
	   }
	   
	   System.out.println(cSum);
	}
	
	static  void sort(int cost[], int maxArea[], int  numAni[], int reqAre[])
	{
		int i,j,temp1, temp2, temp3, temp4;
		
		for(i=1; i<3; i++)
		{
			temp1 = cost[i];
			temp2 = maxArea[i];
			temp3 = numAni[i];
			temp4 = reqAre[i];
		
			for(j=(i-1); j>=0 && temp1>cost[j]; j--)  
			{
			   cost[j+1] = cost[j];	
			   maxArea[j+1] = maxArea[j];	
			   numAni[j+1] = numAni[j];	
			   reqAre[j+1] = reqAre[j];	
			}
			
			cost[j+1] = temp1;
			maxArea[j+1] = temp2;
			numAni[j+1] = temp3;
			reqAre[j+1] = temp4;
	}
}