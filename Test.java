import static java.lang.System.out;
import java.util.Arrays;

public class Test {
    // Initialize the disjoint set
    static void makeSet(int[] parent) {
        Arrays.fill(parent, -1);
    }

    // Find the representative (root) of the set containing x with path compression
    static int find(int x, int[] parent) {
        if (parent[x] < 0) {
            return x;
        } else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }

    // Union by rank
    static void union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX == rootY)
            return;

        // Union by rank
        if (parent[rootX] < parent[rootY]) {
            parent[rootX] += parent[rootY];
            parent[rootY] = rootX;
        } else {
            parent[rootY] += parent[rootX];
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        int[] parent = new int[10];
        makeSet(parent);

        union(1, 2, parent);
        union(3, 4, parent);
        union(2, 4, parent);

        out.println("Parent of 1: " + find(1, parent));
        out.println("Parent of 3: " + find(3, parent));
    }
}