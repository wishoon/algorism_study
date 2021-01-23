package BackJoon.Divide_and_Conquer;

import java.io.IOException;
import java.util.Scanner;

public class Q1629 {

//    이 문제를 해결하기 위해서는 제곱의 성질을 이용하여 분할정복으로 제곱 연산을 O(logn)에 처리하는 알고리즘이다.

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(cal(A, B, C) % C);
    }

    public static long cal(long a, long b, long c){
        // b가 1일 때
        if(b == 1)
            return a;

        long temp = cal(a, b / 2, c) % c;

        // b가 짝수일 때
        if(b % 2 == 0)
            return (temp * temp) % c;
        else
            return (((temp * temp) % c) * a) % c;
    }
}
