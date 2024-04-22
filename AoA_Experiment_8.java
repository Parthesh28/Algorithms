import java.util.*;

public class AoA_Experiment_8 {

    public static void findSubsets(int[] arr, int sum) {
        int[] subset = new int[arr.length];
        findSubsetsutil(arr, sum, 0, subset);
    }

    static void findSubsetsutil(int[] arr, int sum, int index, int[] subset) {
        if (sum == 0) {
            System.out.println("\nThe solution vector is: ");
            for (int i = 0; i < subset.length; i++) {
                System.out.print(subset[i] + " ");
            }
            System.out.println();
            return;
        }

        if (index == arr.length || sum < 0) {
            return;
        }
        subset[index] = 1;
        findSubsetsutil(arr, sum - arr[index], index + 1, subset);
        subset[index] = 0;
        findSubsetsutil(arr, sum, index + 1, subset);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the sum to be obtained: ");
        int sum = sc.nextInt();
        findSubsets(arr, sum);
        sc.close();
    }
}