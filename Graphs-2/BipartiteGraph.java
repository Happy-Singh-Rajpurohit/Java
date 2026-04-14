import java.util.*;

public class BipartiteGraph {
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

    public static boolean isBipartite(ArrayList<Edge>[] graph) {  //O(v+e)
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1; // Initialize all vertices with -1 (uncolored)
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){ // If the vertex is uncolored
                q.add(i);
                color[i] = 0; // Start coloring with color 0

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1){
                            int nextColor = color[curr] == 0 ? 1 : 0; // Alternate color
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false; // If the destination vertex is colored with the same color, then the graph is not bipartite
                        }

                    }
                }
            }
        }

        return true; // If the graph is bipartite
    }

    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
