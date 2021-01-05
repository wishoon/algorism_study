package BackJoon.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        Integer[] n2 = new Integer[n1];

        for (int i = 0; i < n1; i++) {
            n2[i] = sc.nextInt();
        }

        Arrays.sort(n2);
        for (int i = 0; i < n1; i++) {
            System.out.println(n2[i]);
        }
    }
}
