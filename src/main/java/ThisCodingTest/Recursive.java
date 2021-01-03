package ThisCodingTest;

import java.util.Scanner;

public class Recursive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(recursive(num));
    }

    public static int recursive(int n) {

        if (n <= 1)
            return 1;
        return n * recursive(n - 1);
    }
}
