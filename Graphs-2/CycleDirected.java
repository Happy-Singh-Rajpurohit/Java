import java.util.*;

public class CycleDirected {
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

    public static boolean isCycle(ArrayList<Edge>[] graph) {  //O(v+e)
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, visited, recStack, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, boolean[] recStack, int curr) {  //O(v+e)
        visited[curr] = true;
        recStack[curr] = true;

        for (int i=0; i<graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if(recStack[edge.dest]){
                return true;
            } else if(!visited[edge.dest]){
                if(isCycleUtil(graph, visited, recStack, edge.dest)){
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        createGraph(graph);
        System.out.println("Does the graph contain a cycle? " + isCycle(graph));
    }
}
