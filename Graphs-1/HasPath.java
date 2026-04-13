import java.util.*;

public class HasPath {
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

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {//O(v+e)
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {
            if (!visited[edge.dest]) {
                if (hasPath(graph, edge.dest, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        int src = 0;
        int dest = 4;
        boolean[] visited = new boolean[V];
        System.out.println("Is there a path from " + src + " to " + dest + "? " + hasPath(graph, src, dest, visited));
    }
}
