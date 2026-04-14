import java.util.*;

public class TopologicalSortDFS {
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

    public static void topologicalSort(ArrayList<Edge>[] graph) {  //O(v+e)
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSortUtil(graph, visited, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> s, int curr) {
        visited[curr] = true;

        for (int i=0; i<graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if(!visited[edge.dest]){
                topologicalSortUtil(graph, visited, s, edge.dest);
            }
        }

        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        System.out.println("Topological Sort:");
        topologicalSort(graph);
    }
}
