package v2.Programmers;

import java.util.*;

public class 셔틀버스_다시 {
    public static void main(String[] args) {

        int n = 10;
        int t = 1;
        int m = 5;

        String[] timetable = {"09:00", "09:00", "09:00", "09:00", "09:00"};

        System.out.println(solution(n, t, m, timetable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        String start_time = "09:00";
        int start = Integer.parseInt(start_time.split(":")[0]) * 60;

        // timetable 정리 및 시간 순 정렬
        PriorityQueue<Integer> timearray = new PriorityQueue<>();

        for (int i = 0; i < timetable.length; i++) {
            String temp = timetable[i];
            int hour = Integer.parseInt(temp.split(":")[0]) * 60;
            int minute = Integer.parseInt(temp.split(":")[1]);

            timearray.add(hour+minute);
        }

        // 09:00 셔틀버스를 배치시켜 t만큼 간격으로 배치
        List[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();

            while(!timearray.isEmpty()) {
                int arrived_crue = timearray.poll();
                // 현재 도착해 있는 셔틀버스 보다 일찍오고, 셔틀버스 정원이 차지 않았을 경우
                if(arrived_crue <= start && list[i].size() < m) {
                    list[i].add(arrived_crue);
                }
                // 현재 도착하여 있는 크루가 없는 경우
                else {
                    timearray.add(arrived_crue);
                    break;
                }
                // 마지막 크루보다 먼저 와야 하기 떼문에 -1 분을 해줘서 저장
                answer = arrived_crue - 1;
            }
            // 다음 셔틀버스 시간 갱신
            start += t;
        }

        if(list[n-1].size() < m) {
            answer = start - t;
        }

        String hh = String.format("%02d",answer/60);
        String mm = String.format("%02d",answer%60);
        return hh+":"+mm;
    }

}
