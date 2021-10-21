package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int avg = (int) Math.round((double)Arrays.stream(arr).sum() / n);

        Arrays.sort(arr);
        int mid = arr[n / 2];

        // 빈도수 확인
        int[] freq = new int[8001];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] + 4000]++;
        }

        int maxFreq = 0;
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (freq[i] == maxFreq) {
                list.add(i - 4000);
            }
        }

        if (list.size() == 1) {
            max = list.get(0);
        } else {
            max = list.get(1);
        }
        int range = arr[n - 1] - arr[0];


        System.out.println(avg);
        System.out.println(mid);
        System.out.println(max);
        System.out.println(range);
    }
}
