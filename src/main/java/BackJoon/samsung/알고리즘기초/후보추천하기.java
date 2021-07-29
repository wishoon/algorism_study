package BackJoon.samsung.알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 후보추천하기 {

    static int N, K;
    static Person[] people;
    static List<Person> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        people = new Person[101];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(people[num] == null) {
                people[num] = new Person(num, 0, 0, false);
            }

            if(people[num].isIn == true) {
                people[num].recommend++;
            } else {
                // 리스트 크기가 N일 경우
                if(list.size() == N) {
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.recommend = 0;
                    p.isIn = false;
                }
                people[num].recommend = 1;
                people[num].isIn = true;
                people[num].timeStamp = i;
                list.add(people[num]);
            }
        }

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.num - o2.num;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Person person : list) {
            sb.append(person.num + " ");
        }

        System.out.println(sb);
    }

    static class Person implements Comparable<Person> {
        private int num;
        private int recommend;
        private int timeStamp;
        boolean isIn;

        public Person(int num, int recommend, int timeStamp, boolean isIn) {
            this.num = num;
            this.recommend = recommend;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }

        @Override
        public int compareTo(Person s) {
            int result = recommend - s.recommend;

            if(result == 0) {
                return timeStamp - s.timeStamp;
            } else {
                return result;
            }
        }
    }
}
