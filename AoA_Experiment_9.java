import java.util.*;

public class AoA_Experiment_9 {

    public static final int PRIME = 101;

    public static void Rabin_karp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        double patternHash = hash(pattern, m);

        for (int i = 0; i <= n - m; i++) {
            int j;
            double textHash = hash(text.substring(i, i + m), m); 
            boolean match = true;

            if (textHash == patternHash) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at position: " + i);
                }
            }
        }
    }

    public static double hash(String str, int length) {
        double hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue = hashValue +  str.charAt(i) * Math.pow(PRIME, i);
        }
        return hashValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        System.out.println("Enter the text: ");
        String pattern = sc.nextLine();

        Rabin_karp(text, pattern);
        sc.close();
    }
}