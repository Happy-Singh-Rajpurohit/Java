import java.util.*;

public class DFS {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {  //O(v+e)
        System.out.print(curr + " ");
        visited[curr] = true;

        for (Edge edge : graph[curr]) {
            if (!visited[edge.dest]) {
                dfs(graph, edge.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
    }
}
