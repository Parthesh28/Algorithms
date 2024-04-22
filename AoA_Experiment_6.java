import java.util.Scanner;

public class AoA_Experiment_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first sequence: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second sequence: ");
        String str2 = scanner.nextLine();
        findLCS(str1, str2);

        scanner.close();
    }

    public static void findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        String[][] direction = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    direction[i][j] = " ";
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    direction[i][j] = "↖";
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    direction[i][j] = "⬆";
                } else {
                    dp[i][j] = dp[i][j - 1];
                    direction[i][j] = "⬅";
                }
            }
        }

        System.out.println("\nCalculation Table:");
        for (int i = 0; i <= m; i++) {
            System.out.print("Character No. " + i + ":  ");
            for (int w = 0; w <= n; w++) {
                System.out.print(dp[i][w] + "|");
            }
            System.out.println();
        }

        int length = dp[m][n];
        char[] lcs = new char[length];

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[length - 1] = str1.charAt(i - 1);
                i--;
                j--;
                length--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("Length of Longest Common Subsequence: " + lcs.length);
        System.out.print("The Longest Common Subsequence is: ");
        for (int j2 = 0; j2 < lcs.length; j2++) {
            System.out.print(lcs[j2]);
        }
    }
}
