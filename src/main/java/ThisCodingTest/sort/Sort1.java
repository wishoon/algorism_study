package ThisCodingTest.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int k;
        n = sc.nextInt();
        k = sc.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int j = 0; j < n; j++) {
            b[j] = sc.nextInt();
        }

//        a는 오름차순 정렬
        Arrays.sort(a);
//        b는 오름차순 정렬
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
           if(a[i] < b[i]){
               int temp = a[i];
               a[i] = b[i];
               b[i] = temp;
           }
           else break;
        }

        // 배열 A의 모든 값을 출력
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = a[i];
        }
        System.out.println(result);
    }
}
