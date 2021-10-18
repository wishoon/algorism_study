package v3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int h, w;
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 구할 물 웅덩이
        for (int i = 1; i < w - 1; i++) {
            int cur = block[i];
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (cur < block[j]) {
                    left = Math.max(left, block[j]);
                }
            }

            for (int j = i + 1; j < w; j++) {
                if (cur < block[j]) {
                    right = Math.max(right, block[j]);
                }
            }

            // left, right 를 못 구할 수 있는 상황이 발생할 수 있기 때문
            if(Math.min(left, right) > cur) {
                answer += (Math.min(left, right) - cur);
            }
        }

        System.out.println(answer);
    }
    /*
    왼쪽 오른쪽의 block 배열에 최소 2개의 0 이상의 데이터가 있어야 한다.
     */
}
