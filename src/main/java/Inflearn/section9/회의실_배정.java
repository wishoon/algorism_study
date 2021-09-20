package Inflearn.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Time(start, end));
        }

        solution(n, list);
    }

    public static void solution(int n, List<Time> list) {

        int cnt = 0;
        Collections.sort(list);

        int endTime = Integer.MIN_VALUE;

        for (Time time : list) {
            if (endTime <= time.start) {
                endTime = time.end;
                cnt++;
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
        public int compareTo(Time t) {
            if (this.end == t.end) {
                return this.start - t.start;
            } else {
                return this.end - t.end;
            }
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
