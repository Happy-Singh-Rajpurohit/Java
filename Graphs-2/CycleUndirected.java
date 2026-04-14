import java.util.*;

public class CycleUndirected {
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
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {  //O(v+e)
        visited[curr] = true;

        for (Edge edge : graph[curr]) {

            //Case 3 - If the destination vertex is already visited and is not the parent of the current vertex, then there is a cycle in the graph.
            if (!visited[edge.dest]) {
                if(isCycleUtil(graph, visited, edge.dest, curr)){
                    return true;
                }
            } 
            //Case 1 - If the destination vertex is already visited and is the parent of the current vertex, then there is no cycle in the graph.
            else if(edge.dest != parent){
                return true;
            }

            //Case 2 - If the destination vertex is not visited, then we can continue to explore the graph.
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
        System.out.println(isCycle(graph));
    }
}
