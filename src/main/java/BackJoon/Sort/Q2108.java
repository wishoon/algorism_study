package BackJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // -4000에서 ~ 4000까지의 정수를 다루기 때문에 8000까지 check 할 수 있는 배열을 선언한 뒤 해당값에 +4000을 ++해주면 음수값도 다룰 수 있다.
        int[] arr = new int[8001];

        // 합계, 산술 평균, 중앙값, 최빈값, 최대값, 최솟값
        int sum = 0;
        int median = 0;
        int mode = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            if(max < value) {
                max = value;
            }
            if(min > value) {
                min = value;
            }
        }

        int count = 0; // 중앙값 빈도 누적 수
        int mode_max = 0;
        // 이전의 동일한 최빈값이 1번만 등장했을 경우 true, 아니면 false
        boolean flag = false;

        for(int i = min + 4000; i<= max + 4000; i++){
            if(arr[i] > 0){

                // 중앙값 찾기
                if(count < (n + 1) / 2){
                    count += arr[i];
                    median = i - 4000;
                }

                // 최빈값 찾기
                if(mode_max < arr[i]){
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                }

                else if(mode_max == arr[i] && flag == true){
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        // 산술 평균
        System.out.println((int)Math.round((double)sum / n));	// 산술평균
        System.out.println(median);	// 중앙값
        System.out.println(mode);	// 최빈값
        System.out.println(max - min);	// 범위


    }
}
