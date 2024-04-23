import java.util.Scanner;

public class AoA_Experiment_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first sequence: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second sequence: ");
        String str2 = scanner.nextLine();
        FindLCS(str1, str2);

        scanner.close();
    }

    public static void FindLCS(String str1, String str2) {
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
                System.out.print(dp[i][w] + direction[i][w] +  " |");
            }
            System.out.println();
        }
        System.out.print("\nThe LCS is:");
        PrintLCS(direction, str1, m, n);
        System.out.print("\nThe length of LCS is: "+ dp[m][n]);
    }

    public static void PrintLCS(String[][] direction, String str1, int i, int j){
        if(i == 0 || j == 0) return; 
        if(direction[i][j] == "↖"){
            PrintLCS(direction, str1, (i-1), (j-1));
            System.out.print(str1.charAt(i-1));
        }
        else if(direction[i][j] == "⬆"){
            PrintLCS(direction, str1, i-1, j);
        }
        else PrintLCS(direction, str1, i, j-1);
    }
}
