import java.util.*;

public class CreateGraphs {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(1, 3, 12));
        graph[2].add(new Edge(2, 4, 10));
        graph[3].add(new Edge(3, 4, 5));

        // Print the graph
        for (int i = 0; i < V; i++) {
            for (Edge edge : graph[i]) {
                System.out.println("Source: " + edge.src + ", Destination: " + edge.dest + ", Weight: " + edge.wt);
            }
        }
    }
}
