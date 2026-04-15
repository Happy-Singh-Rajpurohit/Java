import java.util.*;

public class TopologicalSortBFS {
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

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i=0; i<graph.length; i++) {
            int v = i;
            for (int j=0; j<graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {  
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
            
        //BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
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
        System.out.println("Topological Sort:");
        topologicalSort(graph);
    }
}
