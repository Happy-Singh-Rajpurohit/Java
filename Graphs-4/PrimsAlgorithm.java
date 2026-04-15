import java.util.*;

public class PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // 0 - 1
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        // 0 - 2
        graph[0].add(new Edge(0, 2, 50));
        graph[2].add(new Edge(2, 0, 50));

        // 1 - 3
        graph[1].add(new Edge(1, 3, 25));
        graph[3].add(new Edge(3, 1, 25));

        // 2 - 4
        graph[2].add(new Edge(2, 4, 34));
        graph[4].add(new Edge(4, 2, 34));

        // 3 - 4
        graph[3].add(new Edge(3, 4, 10));
        graph[4].add(new Edge(4, 3, 10));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // v, cost
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.v]) {
                visited[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Final Cost: " + finalCost);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        System.out.println("Minimum Spanning Tree:");
        prims(graph);
    }
}
