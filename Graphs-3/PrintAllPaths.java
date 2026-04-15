import java.util.*;

public class PrintAllPaths {
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

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest){
            System.out.println(path + dest);
            return;
        }

        for (int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        System.out.println("All paths from 0 to 4:");
        printAllPaths(graph, 0, 4, "");
    }
}
