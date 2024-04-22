import java.util.*;

public class AoA_Experiment_1 {

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("The sorted array is due to insertion sort is: ");
        printArray(arr);
    }

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j])
                    j = k;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println("The sorted array is due to selection sort is: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arb = new int[n];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(n);
            arb[i] = arr[i];
        }

        System.out.println("Insertion Sort:");
        InsertionSort(arr);

        System.out.println("Selection Sort:");
        SelectionSort(arb);

        sc.close();
    }
}