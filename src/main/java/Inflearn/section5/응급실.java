package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Person> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(new Person(i, Integer.parseInt(st.nextToken())));
        }

        int answer = 1;
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();

            for (Person person : queue) {
                if(person.priority > tmp.priority) {
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                if(tmp.id == M){
                    System.out.println(answer);
                } else {
                    answer++;
                }
            }
        }
    }

    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}
