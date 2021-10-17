package v3.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a < b) {
            System.out.println("<");
        } else if(a == b) {
            System.out.println("==");
        } else {
            System.out.println(">");
        }
    }
}
