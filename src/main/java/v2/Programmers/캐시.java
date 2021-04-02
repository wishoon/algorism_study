package v2.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public static void main(String[] args) {

        int casheSize = 2;
        String[] cities = {"Jeju", "Jeju", "Jeju", "Seoul", "Seoul"};

        solution(casheSize, cities);
    }

    public static void solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();

        int time = 0;
        for (String city : cities) {
            city = city.toUpperCase();

            if(queue.isEmpty()) {
                queue.offer(city);
                time += 5;
            }
            else {
                if(queue.contains(city)) {
                    time += 1;
                    queue.remove(city);
                    queue.offer(city);
                    continue;
                } else {
                    time += 5;
                    queue.offer(city);
                }
            }
            if(queue.size() > cacheSize) {
                queue.poll();
            }
        }

        System.out.println(time);
    }
}
