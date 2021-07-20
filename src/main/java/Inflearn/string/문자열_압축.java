package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        solution(input + " ");
    }

    private static void solution(String input) {
        StringBuilder sb = new StringBuilder();
        char[] c = input.toCharArray();

        char record = 0;
        int count = 0;

        for (char temp : c) {
            if(record == 0) {
                record = temp;
                count++;
            }
            else if(record == temp) {
                count++;
            } else {
                if(count > 1) {
                    sb.append(record + "" + count);
                    count = 1;
                } else {
                    sb.append(record);
                }
                record = temp;
            }
        }


        System.out.println(sb.toString());
    }
}
