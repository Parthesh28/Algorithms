import java.util.*;

public class AoA_Experiment_4 {
    public static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Kruskal's Algorithm:");
        kruskalMST(vertices, graph);

        System.out.print("Enter the source vertex for Prim's Algorithm: ");
        int arbitary = scanner.nextInt();
        System.out.println("Prim's Algorithm:");
        Prims(graph, arbitary);

        scanner.close();
    }

    public static void kruskalMST(int vertices, int[][] graph) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Edge[] edges = getEdges(vertices, graph);
        System.out.println("\nEdges in the Minimum Spanning Tree:");
        int edgeCount = 0;
        int totalCost = 0;
        for (Edge edge : edges) {
            int root1 = find(parent, edge.src);
            int root2 = find(parent, edge.dest);

            if (root1 != root2) {
                System.out.println(edge.src + " -> " + edge.dest);
                parent[root1] = root2;
                totalCost += edge.weight;
                edgeCount++;
            }
            if (edgeCount == vertices - 1) {
                break;
            }
        }
        System.out.println("\nMinimum cost of the spanning tree: " + totalCost);
    }

    public static Edge[] getEdges(int vertices, int[][] graph) {
        int edgeCount = 0;
        Edge[] edges = new Edge[vertices * vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (graph[i][j] != 0) {
                    edges[edgeCount++] = new Edge(i, j, graph[i][j]);
                }
            }
        }
        Arrays.sort(edges, 0, edgeCount);
        return Arrays.copyOfRange(edges, 0, edgeCount);
    }

    public static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    public static void Prims(int[][] graph, int arbitary) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        int[] pred = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = INFINITY;
            pred[i] = -1;
            visited[i] = false;
        }
        dist[arbitary] = 0;
        pred[arbitary] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = -1;
            int minDist = INFINITY;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && dist[v] < minDist) {
                    u = v;
                    minDist = dist[v];
                }
            }
            visited[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] < dist[v]) {
                    pred[v] = u;
                    dist[v] = graph[u][v];
                }
            }
        }
        printMST(pred, dist, arbitary);
    }

    public static void printMST(int[] pred, int[] dist, int arbitary) {
        System.out.println("\nEdges in the Minimum Spanning Tree:");
        int totalCost = 0;

        for (int i = 0; i < pred.length; i++) {
            if (i != arbitary) {
                System.out.println(pred[i] + " -> " + i);
                totalCost += dist[i];
            }
        }
        System.out.println("\nMinimum cost of the spanning tree: " + totalCost);
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
