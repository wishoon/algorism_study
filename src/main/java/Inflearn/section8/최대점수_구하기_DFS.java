package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수_구하기_DFS {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, m = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 점수, 시간
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr[i] = new Student(score, time);
        }

        dfs(arr, m, 0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(Student[] student, int limit, int depth, int sum, int time) {
        if(limit < time) {
            return;
        }
        if(depth == student.length) {
            max = Math.max(max, sum);
        } else {
            dfs(student, limit, depth + 1, sum + student[depth].score, time + student[depth].time);
            dfs(student, limit, depth + 1, sum, time);
        }
    }

    static class Student {
        int score;
        int time;

        public Student(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
