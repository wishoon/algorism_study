package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가르침 {

    public static boolean[] visited = new boolean[26];
    public static int[] numbers;
    public static int N, K;
    public static int max = 0;
    public static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        if(K < 5) {
            System.out.println(0);
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }
        else {
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                list.add(str.substring(4, str.length() - 4));
            }

            visited['a' - 97] = true;
            visited['n' - 97] = true;
            visited['t' - 97] = true;
            visited['i' - 97] = true;
            visited['c' - 97] = true;

            numbers = new int[K - 5];
            combination(0, 0);
            System.out.println(max);
        }
    }

    private static void combination(int start, int idx) {
        if(idx == K - 5) {

            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isTrue = true;

                for (int j = 0; j < list.get(i).length(); j++) {
                    if (!visited[list.get(i).charAt(j) - 97]) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(start, idx + 1);
                visited[i] = false;
            }
        }
    }
}
