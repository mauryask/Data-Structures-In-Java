// https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/

// Time Complexity: 𝑂(𝑛2×log 𝑛)
// Space Complexity: 𝑂(𝑛2)

import static java.lang.System.*;
import java.util.*;

public class DisjkstraIn2DGrid 
{
    static boolean isValidCell(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    static int minimumCostPath(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = grid[0][0]; // Initialize with grid[0][0] like we start with 0 for source vertex in graph
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int c = top[0]; // Cost of source vertex (u)
			int i = top[1]; // row 
			int j = top[2]; // col
			// Go in all the 4 directions
            for (int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];
				//Check if valid cell and cost[u] + e.w (grid[i][j]) < cost[e.v]
				
                if (isValidCell(x, y, n) && cost[i][j] + grid[x][y] < cost[x][y]) {
                    cost[x][y] = cost[i][j] + grid[x][y];
                    pq.offer(new int[]{cost[x][y], x, y});
                }
            }
        }
        return cost[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {9, 4, 9, 9},
            {6, 7, 6, 4},
            {8, 3, 3, 7},
            {7, 4, 9, 10}
        };
		
        out.println(minimumCostPath(grid));
    }
}