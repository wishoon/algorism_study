package ThisCodingTest;

import java.util.Scanner;

public class Greedy1 {
    public static void main(String[] args) {
//        내가 작성한 코드
    /*    int n = 0;
        int k = 0;
        int cnt = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        while(n != 1){
            if(n%k == 0){
                n = n/k;
                cnt++;
            }
            else{
                n--;
                cnt++;
            }
        }
        System.out.println(cnt);*/
//        강사가 작성한 코드
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while(true){
            // N이 K로 나누어 떨어지느느 수가 될 때가지 빼기
            int target = (n/k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때(더 이상 나눌 수 없을 때) 반복문 탈출
            if(n<k)
                break;
            // K로 나누기
            n /= k;
            result += 1;
        }
        // 마지막으로 남은 수들 더하기
        result += (n-1);
        System.out.println(result);
    }
}
