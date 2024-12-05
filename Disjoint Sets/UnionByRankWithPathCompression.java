/*
* T(n) : 𝑂(𝐸𝛼(𝑉)) 
** The time compelxity will be almost linear
* S(n) : O(V)
** Union by rank (size) with path compression (collapsing find)
**/

import static java.lang.System.*;
import java.util.*;

public class UnionByRankWithPathCompression {
    // This is the true path compression
    static int find(int key, int[] rank) {
        if (rank[key] < 0) {
            return key;
            
        } else {
            rank[key] = find(rank[key], rank);
            return rank[key];
        }
    }

    static void union(int x, int y, int[] rank) {
        int setX = find(x, rank);
        int setY = find(y, rank);

        if (setX == setY) {
            out.println("Edge causing cycle: ( " + x + ", " + y + ")");
        } else {
            int rankX = Math.abs(rank[setX]);
            int rankY = Math.abs(rank[setY]);

            if (rankY > rankX) {
                rank[setX] = setY;
                rank[setY] -= rankX;
            } else {
                rank[setY] = setX;
                rank[setX] -= rankY;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] rank = new int[n];
        Arrays.fill(rank, -1);
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

        for (int[] edge : edges)
            union(edge[0], edge[1], rank);
    }
}