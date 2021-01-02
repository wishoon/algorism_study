package ThisCodingTest;

import java.util.Scanner;

// 완전 탐색 - 가능한 모든 시간의 경우를 하나씩 모두 세서 풀 수 있는 문제
public class Implementation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int num = sc.nextInt();

        for(int i=0; i<=num; i++){
            for(int j=0; j<60; j++){
                for(int k=0; k<60; k++){
                    if(check(i, j, k))
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static boolean check(int i, int j, int k){
        if(i%10==3 || j/10 == 3 || j%10 == 3 || k/10 == 3 || k%10 == 3){
            return true;
        }
        else
            return false;
    }
}