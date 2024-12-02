import static java.lang.System.out;
import java.util.Arrays;

public class Test {
    static void makeSet(int[] rank) {
        Arrays.fill(rank, -1);
    }

    static int find(int x, int[] rank) {
        int temp = x;

        while (rank[temp] >= 0) {
            temp = rank[temp];
        }

        // Path compresion (Collapsing find)
        rank[x] = temp;

        return temp;
    }

    // Union by rank
    static void union(int x, int y, int[] rank) {
        int xSet = find(x, rank);
        int ySet = find(y, rank);

        if (xSet == ySet)
            return;

        int xRank = Math.abs(rank[xSet]);
        int yRank = Math.abs(rank[ySet]);

        if (xRank > yRank) {
            rank[xSet] = -1 * (xRank + yRank);
            rank[ySet] = xSet;
        } else {
            rank[ySet] = -1 * (xRank + yRank);
            rank[xSet] = ySet;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[] rank = new int[n];
        makeSet(rank);

        union(0, 1, rank);
        union(2, 3, rank);
        union(5, 6, rank);
        union(0, 5, rank);
        union(6, 2, rank);
        union(3, 4, rank);
        union(4, 3, rank);

        for (int i = 0; i < n; i++)
            out.println(i + " => " + rank[i]);
    }
}