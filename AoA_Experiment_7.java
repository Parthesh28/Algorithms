import java.util.Scanner;
public class AoA_Experiment_7 {
    public static void graphColoring(int k, int n, int[] x, int[][] graph, int colors) {
        while (true) {
            nextValue(k, x, n, graph, colors);
            if (x[k] == 0) {
                return;
            }
            if (k == n) {
                System.out.print("Solution: ");
                System.out.print("{ ");
                for (int i = 1; i <= n; i++) {
                    System.out.print( x[i] + " ");
                }
                System.out.println("}");
            }
            else {
                graphColoring(k + 1, n, x, graph, colors);
            }
        }
    }

    public static void nextValue(int k, int[] x, int n, int[][] graph, int colors) {
        int j =1;
        while (true) {
            x[k] = (x[k] + 1) % (colors + 1);
            if (x[k] == 0) {
                return;
            }
            for (j = 1; j <= n; j++) {
                if (graph[k][j] != 0 && (x[k] == x[j])) {
                    break;
                }
            }
            if (j == n+1) {
                    return;
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.println("Enter the number of colors: ");
        int colors = sc.nextInt();
        int[][] graph = new int[vertices+1][vertices+1];
        int[] solutionVector = new int[vertices+1];
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        graphColoring(1, vertices, solutionVector, graph, colors);
        sc.close();
    }
}
