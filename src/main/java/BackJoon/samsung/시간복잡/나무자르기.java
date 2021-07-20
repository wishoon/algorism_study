package BackJoon.samsung.시간복잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {

    static int N, M;
    static int[] tree;

    // 파라메트릭 서치 : 정확한 값이 아니라 범위 값(최소 값, 최대 값), 바이너리 서치: 정확한 숫자를 찾아 내는 것(값이 있다, 없다)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int start = 0, end = 0;

        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(tree[i], end);
        }

        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if(tree[i] > mid) {
                    total += tree[i] - mid;
                }
            }

            if(total < M) {
                // mid 값이 의미가 없기 때문에 한 칸 앞으로 이동한다.
                end = mid - 1;
            } else {
                // 역시 mid 값이 의미가 없기 때문에 한 칸 위로 이동한다.
                start = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
