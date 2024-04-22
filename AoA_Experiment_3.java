import java.util.*;

public class AoA_Experiment_3 {
    static final int INFINITY = Integer.MAX_VALUE;

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
        
        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        dijkstra(graph, source);

        scanner.close();
    }

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        int[] pred = new int[vertices];
        boolean[] visited = new boolean[vertices];
    
        for (int i = 0; i < vertices; i++) {
            dist[i] = INFINITY;
            pred[i] = -1;
        }
        dist[source] = 0;
    
        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistanceVertex(dist, visited);
            visited[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0) {
                    int newDistance = dist[u] + graph[u][v];
                    if (newDistance < dist[v]) {
                        dist[v] = newDistance;
                        pred[v] = u;
                    }
                }
            }
        }
        printSolution(source, dist, pred);
    }

    public static int minDistanceVertex(int[] dist, boolean[] visited) {
        int minDist = INFINITY;
        int minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < minDist) {
                minDist = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void printSolution(int source, int[] dist, int[] pred) {
        int vertices = dist.length;
        System.out.println("Vertex \t Distance \t\t\t Path");
        for (int v = 0; v < vertices; v++) {
            System.out.print(v + " \t\t ");
            if (dist[v] == INFINITY) {
                System.out.print("INF \t\t\t ");
                System.out.println("No path from " + source + " to " + v);
            } else {
                System.out.print(dist[v] + "\t\t\t ");
                printPath(source, v, pred);
            }
            System.out.println();
        }
    }

    public static void printPath(int source, int current, int[] pred) {
        if (current == source) {
            System.out.print(source);
        } else if (pred[current] == -1) {
            System.out.print("No path from " + source + " to " + current);
        } else {
            printPath(source, pred[current], pred);
            System.out.print(" -> " + current);
        }
    }
}
