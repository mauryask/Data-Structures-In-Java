import static java.lang.System.out;
import java.util.Arrays;

public class Test {

    class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    int vNum;
    int eNum;
    Edge[] edges;

    Test(int vNum, int eNum) {
        this.vNum = vNum;
        this.eNum = eNum;
        edges = new Edge[eNum];
    }

    void addEdge(int u, int v, int w, int index)
    {
        edges[index] = new Edge(u, v, w);
    }

    boolean relaxEdge(int[] dist)
    {
        boolean isRelaxed  = false;

        for(int i=0; i<eNum; i++)
        {
            int u = edges[i].u;
            int v = edges[i].v;
            int w = edges[i].w;

            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
            {
                dist[v] = dist[u] + w;
                isRelaxed = true;
            }
        }

        return isRelaxed;
    }

    void bellmanFord(int src)
    {
        int[] dist = new int[vNum];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=1; i<=vNum-1; i++)
        {
           relaxEdge(dist);
        }

        if(relaxEdge(dist))
           out.println("Negative edge weight cycle present!!");   
    }

    public static void main(String[] args) {
       int x = (int)1e8;
       out.println(x);
    }
}
