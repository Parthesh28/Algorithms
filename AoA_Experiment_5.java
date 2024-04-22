import java.util.*;

public class AoA_Experiment_5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int[] weights= new int[n];
        int[] profit= new int[n];
        
        System.out.println("Enter the weights of items: ");
        for (int i = 0; i < weights.length; i++) {
            weights[i]= sc.nextInt();
        }
        System.out.println("Enter the profits of items: ");
        for (int i = 0; i < weights.length; i++) {
            profit[i]= sc.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();

        DP_Knapsack(weights, profit, capacity);
        sc.close();
    }

    public static void DP_Knapsack(int[] weights, int[] profit, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], profit[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("The maximum profit is : " + dp[n][capacity] + " units");

        System.out.println("\nCalculation Table:");
        for (int i = 0; i <= n; i++) {
            System.out.print("Item no.: "+ i+ ":  ");
            for (int w = 0; w <= capacity; w++) {
                System.out.print(dp[i][w] + " | ");
            }
            System.out.println();
        }

        List<Integer> selectedItems = new ArrayList<>();
        int i = n, w = capacity;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(i - 1);
                w -= weights[i - 1];
            }
            i--;
        }

        System.out.println("\nItems in the knapsack: ");
        for (int index : selectedItems) {
            System.out.println("Item No.:  " + (index + 1) + " | Profit: " + profit[index] + " units | Weight: " + weights[index]);
        }
    }
}