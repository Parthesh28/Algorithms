import java.util.*;

public class AoA_Experiment_9 {
    public static final int PRIME = 11;
    public static final int RADIX = 256;

    public static void Rabin_karp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int spurious_hits = 0; 
        double patternHash = hash(pattern, m);
        double texthash = hash(text, m);
        System.out.println("The pattern hash is: "+ patternHash);
        System.out.println("The text hash is: "+ texthash);

        for (int i = 0; i <= n - m; i++) {
            double textHash = hash(text.substring(i, i + m), m); 
            boolean match = true;
            if (textHash == patternHash) {
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        spurious_hits = spurious_hits + 1;
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found after : " + i + " shifts");
                    System.out.println("No. of Spurious Hits:  " + spurious_hits);
                }
            }
        }
    }

    public static double hash(String str, int length) {
        double hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue = (hashValue * RADIX +  str.charAt(i)) % PRIME;
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
