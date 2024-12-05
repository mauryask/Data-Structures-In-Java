import static java.lang.System.out;
import java.util.Arrays;

public class Test {
    static void makeSet(int[] rank) {
        Arrays.fill(rank, -1);
    }

    static int find(int x, int[] rank) {
        if (rank[x] < 0) {
            return x;
        } else {
            rank[x] = find(rank[x], rank);
            return rank[x];
        }
    }

    // Union by rank
    static void union(int x, int y, int[] rank) {
        int xSet = find(x, rank);
        int ySet = find(y, rank);

        if (xSet == ySet)
            return;

        int xRank = Math.abs(rank[xSet]);
        int yRank = Math.abs(rank[ySet]);

        if (yRank > xRank) {
            rank[ySet] -= xRank;
            rank[xSet] = ySet;
        } else {
            rank[xSet] -= yRank;
            rank[ySet] = xSet;
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