package v3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1931 {

    static int n;
    static Time[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Time(start, end);
        }

        Arrays.sort(arr);

        int cnt = 1;
        int endCurTime = arr[0].end;
        for (int i = 1; i < n; i++) {
            int nextStartTime = arr[i].start;
            if(endCurTime <= nextStartTime) {
                cnt++;
                endCurTime = arr[i].end;
            }
        }

        System.out.println(cnt);
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {

            if(this.end == time.end) {
                return this.start - time.start;
            }

            return this.end - time.end;
        }
    }
}
