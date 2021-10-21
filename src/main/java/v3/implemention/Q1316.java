package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = n;
        for (int i = 0; i < n; i++) {
            HashSet<Character> alpha = new HashSet<>();
            String str = br.readLine();
            char previous = 0;

            for (char c : str.toCharArray()) {
                if(previous == c) {
                    continue;
                }
                previous = c;
                if(alpha.contains(c)) {
                    answer--;
                    break;
                }
                alpha.add(c);
            }
        }
        System.out.println(answer);
    }
}
