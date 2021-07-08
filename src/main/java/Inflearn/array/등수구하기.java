package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        solution(n, input);
    }

    public static void solution(int n, String input) {
        String[] arr = input.split(" ");

        int[] score = new int[arr.length];

        Arrays.fill(score, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i == j)
                    continue;

                if(Integer.parseInt(arr[i]) < Integer.parseInt(arr[j])) {
                    score[i]++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(score[i]);
        }
    }
}
