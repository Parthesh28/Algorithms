import java.util.*;

public class AoA_Experiment_10 {
    public static int[] Prefix_Function(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int i = 0;

        for (int j = 1; j < m; j++) {
            while (i > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                i = pi[i - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
            }
            pi[j] = i;
        }
        return pi;
    }

    public static void KMPMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] pi = Prefix_Function(pattern);
        System.out.println("Prefix array:");
         for (int i = 0; i < m; i++) {
                System.out.print(pi[i] + " ");
           }
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (i > 0 && pattern.charAt(i) != text.charAt(j)) {
                i = pi[i - 1];
            }
            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
            }
            if (i == m) {
                System.out.println("\nPattern occurs after "+(j - m + 1)+ " shifts");
                i = pi[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        System.out.println("Enter the pattern");
        String pattern = sc.nextLine();
        KMPMatch(text, pattern);
    }

}
