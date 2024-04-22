import java.util.*;

public class AoA_Experiment_2 {

    public static void MergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            MergeSort(arr, left, middle);
            MergeSort(arr, (middle + 1), right);
            Merge(arr, left, middle, right);
        }
    }

    public static void Merge(int[] arr, int left, int middle, int right) {
        int[] arrb = new int[arr.length];

        int i = left;
        int j = left;
        int k = middle + 1;

        while (i <= middle && k <= right) {
            if (arr[i] <= arr[k]) {
                arrb[j] = arr[i];
                i = i + 1;
            } else {
                arrb[j] = arr[k];
                k = k + 1;
            }
            j = j + 1;
        }

        if (i > middle) {
            for (int h = k; h <= right; h++) {
                arrb[j] = arr[h];
                j = j + 1;
            }
        } else {
            for (int h = i; h <= middle; h++) {
                arrb[j] = arr[h];
                j = j + 1;
            }
        }
        for (int h = left; h <= right; h++) {
            arr[h] = arrb[h];
        }
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = Partition(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);
        }
    }

    public static int Partition(int[] arr, int low, int high) {
        int x = arr[low];
        int down = low;
        int up = high;
        while (down < up) {
            while (arr[down] <= x && down < high) {
                down = down + 1;
            }
            while (arr[up] > x) {
                up = up - 1;
            }
            if (down <= up) {
                int temp = arr[down];
                arr[down] = arr[up];
                arr[up] = temp;
            }
        }
        arr[low] = arr[up];
        arr[up] = x;
        return up;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the number of elemnts in the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        int[] arb = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size);
            arb[i] = arr[i];
        }

        MergeSort(arr, 0, size - 1);
        System.out.println("\nMerge Sort Ouput: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arr[i]);
        }

        QuickSort(arb, 0, size - 1);
        System.out.println("\nQuick Sort Ouput: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arb[i]);
        }
        sc.close();
    }
}
