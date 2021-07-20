package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 뒤집은_소수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        solution(n, str);
    }

    private static void solution(int n, String str) {

        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = str.split(" ");

        for (String s : arr) {
            char[] c = s.toCharArray();

            for (int i = 0; i < c.length / 2; i++) {
                char temp = c[i];
                c[i] = c[c.length - i - 1];
                c[c.length - i - 1] = temp;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                sb.append(c[i]);
            }
            int result = Integer.parseInt(sb.toString());
            if (isPrime(result) == true) {
                list.add(result);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
