import java.util.*;

public class BellmanFordAlgorithm {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 20));
        graph[1].add(new Edge(1, 3, 30));
        graph[2].add(new Edge(2, 4, 40));
        graph[3].add(new Edge(3, 4, 50));
    }

    public static void BellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i=0; i<dist.length; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //O(V*E) - Bellman Ford Algorithm
        //O(V) initialization step
        for (int i=0; i<graph.length-1; i++) {
            //O(E)- relaxation step 2 for loops
            for (int j=0; j<graph.length; j++) {
                for (int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        //print shortest path from src to all vertices
        for (int i=0; i<dist.length; i++) {
            System.out.println("Shortest path from " + src + " to " + i + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        BellmanFord(graph, 0);
    }
}
