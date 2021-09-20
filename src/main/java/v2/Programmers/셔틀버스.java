package v2.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 셔틀버스 {
    public static void main(String[] args) {

        int n = 1;
        int t = 1;
        int m = 5;

        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};

        System.out.println(solution(n, t, m, timetable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {

        // 셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열 timetable

        // 무조건 버스는 09:00에 출발을 한다.
        // 버스에 타는 조건은 09:00 1분 전 혹은 그 이상 전에 도착을 해 있는 경우
        // 09:00에 도착을 하더라도 만약 탑승 인원수가 남아있는 경우

        // 구하고자 하는 경우는 셔틀을 타고 사무실로 갈 수 있는 도착 시간중 가장 늦은 시간을 구하면 된다.


        String str_start_time = "09:00";
        int start = Integer.parseInt(str_start_time.split(":")[0]) * 60;

        // timetable 정리 및 시간 순 정렬
        List<Integer> timearray = new ArrayList<>();

        for (int i = 0; i < timetable.length; i++) {
            String temp = timetable[i];
            int th = Integer.parseInt(temp.split(":")[0]) * 60;
            int tm = Integer.parseInt(temp.split(":")[1]);

            timearray.add(th + tm);
        }

        // timeArray 정렬하는 부분
        Collections.sort(timearray);


        // 셔틀 운행 횟수
        // 기준 시간에 맞는 셔틀에 탈 수 있는 최대 크루 수 확인
        // 만약 제한 수량과 동일 할 경우 -> 해당 시간 저장 후 재탐색
        // 인원이 부족 한 경우 -> 해당 시간 - 1초 하여 저장 후 재탐색

        int answer = 540;
        int index = 0;
        for (int i = 0; i < n; i++) {

            // 해당 번 탐색의 크루 수
            int count = 0;
            while (count != m) {

                // 만약 조회할 인덱스가 timearray와 같아진다면 반복문 탈출
                if (index == timearray.size()) {
                    break;
                }

                if (timearray.get(index) <= start) {
                    count++;
                    index++;
                } else {
                    // 만약 정렬한 timearray의 수 중 start 보다 작거나 같은 수가 m 보다 작다면
                    break;
                }
            }

            // 만약 크루 수와 m이 같다면
            if (count == m) {
                answer = Math.max(answer, start - 1);
            } else {
                answer = Math.max(answer, start);
            }

            start += t;
        }

        String hh = String.format("%02d", answer / 60);
        String mm = String.format("%02d", answer % 60);

        return hh + ":" + mm;
    }
}
