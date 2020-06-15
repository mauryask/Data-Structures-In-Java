class AllPairShortestPath
{
	void floydWarshall(int G[][], int v_num)
	{
		int i,j,k;
		int dist[][] = new int[v_num][v_num];
		//initialize dist matrix with original matrix
		for(i=0; i<v_num; i++)
			for(j=0; j<v_num; j++)
				dist[i][j] = G[i][j];
			
			for(k=0; k<v_num; k++)
			{
				for(i=0; i<v_num; i++)
				{
					for(j=0; j<v_num; j++)
					{
						if(dist[i][k] != Integer.MAX_VALUE &&
						dist[k][j] != Integer.MAX_VALUE &&
						(dist[i][k] + dist[k][j]) < dist[i][j])
							dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
			
			printDist(dist, v_num);
	}
	
	void printDist(int dist[][], int v_num)
	{
		for(int i=0; i<v_num; i++)
		{
			for(int j=0; j<v_num; j++)
			{
				System.out.println(i+" ==> "+j+" = "+dist[i][j]);
			}
			
			System.out.println("\n===============\n");
		}
	}
}

public class FloydWarShallsAlgorithm
{
	static final int inf = Integer.MAX_VALUE;
	
	public static void main(String [] args)
	{
		AllPairShortestPath a = new AllPairShortestPath();
		int graph[][] = {
							{0, 5, inf, 10},
							{inf,0 , 3, inf},
							{inf, inf, 0, 1},
							{inf, inf, inf, 0}
		                };
		
		a.floydWarshall(graph, graph.length);
	}
}