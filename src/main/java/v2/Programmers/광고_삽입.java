package v2.Programmers;

import java.util.*;

public class 광고_삽입 {
    /**
     * 각 로그 별 시작 시간 부터 광고 타임 종료 시간까지에 속해 있는 로그를 카운팅
     * 가장 많이 속해 있는 값을 반환*/

    public static void main(String[] args) {

        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {

        int[] time_array = new int[secondChange(play_time) + 1];

        int play_secTime = secondChange(play_time);
        int adv_secTime = secondChange(adv_time);

        for (int i = 0; i < logs.length; i++) {

            int start_secTime = secondChange(logs[i].substring(0, 8));
            int end_secTime = secondChange(logs[i].substring(9));

            for (int j = start_secTime; j < end_secTime; j++) {
                time_array[j] += 1;
            }
        }

        long sum_curTime = 0;

        for (int i = 0; i < adv_secTime ; i++) {
           sum_curTime += time_array[i];
        }

        long sum_maxTime = sum_curTime;
        int maxIdx = 0;
        for (int i = adv_secTime; i < play_secTime; i++) {
            sum_curTime = sum_curTime + time_array[i] - time_array[i - adv_secTime];

            if(sum_curTime > sum_maxTime) {
                sum_maxTime = sum_curTime;
                maxIdx = i - adv_secTime + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxIdx / 3600, maxIdx / 60 % 60, maxIdx % 60);
    }

    public static int secondChange(String time) {

        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2]);

        int totaltime = (hour * 60 * 60) + (minute * 60) + (second);

        return totaltime;
    }


    /*static List<Node> result = new ArrayList<>();

    // play_time : 동영상 총 재생 시간, adv_time: 광고 총 재생 시간, logs : 시청 기록
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

//        int sec_play_time = secondChange(play_time);
        long sec_adv_time = secondChange(adv_time);

        if(play_time.equals(adv_time))
            return "00:00:00";

        for (int i = 0; i < logs.length; i++) {

            // 로그 시작과 끝 분할
            String[] log_split = logs[i].split("-");

            // 기준이 되는 로그의 시작 시간
            long sec_start_time = secondChange(log_split[0]);
//            int sec_end_time = secondChange(log_split[1]);

            // 기준이 되는 광고의 종료 시간
            long sec_adv_end_time = sec_start_time + sec_adv_time;

            // list에 시작 시간과 일치 여부 카운트 저장
            result.add(new Node(log_split[0], sec_start_time, 0));

            for (int j = 0; j < logs.length; j++) {
                String[] judge_log_split = logs[j].split("-");

                long sec_log_start_time = secondChange(judge_log_split[0]);
                long sec_log_end_time = secondChange(judge_log_split[1]);

                // 광고 시작 시간 ~ 광고 종료 시간안에 포함되는지 sec_start_time, sec_adv_end_time

                // 끝 로그 보다 광고 시작 시간이 큰가? && 시작 로그 보다 광고 종료 시간이 작은가?

                if(sec_log_end_time < sec_start_time || sec_log_start_time > sec_adv_end_time) {
                    continue;
                }
                result.get(i).setCount(result.get(i).getCount() + 1);
            }
        }

        Collections.sort(result, (o1, o2) -> {

            if(o1.count == o2.count) {
                if(o1.sec_time < o2.sec_time)
                    return -1;
            } else {
                if(o1.count > o2.count)
                    return -1;
            }
            return 1;
        });

//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i).start_time + " " +result.get(i).sec_time + " " + result.get(i).count);
//        }

        // 리스트 카운트 내림차순 정렬 및 시간 오름차순 정렬
        return result.get(0).start_time;
    }

    public static long secondChange(String time) {

        String[] split = time.split(":");

        long hour = Integer.parseInt(split[0]);
        long minute = Integer.parseInt(split[1]);
        long second = Integer.parseInt(split[2]);

        long totaltime = (hour * 60 * 60) + (minute * 60) + (second);

        return totaltime;
    }

    static class Node {
        private String start_time;
        private long sec_time;
        private long count;

        public Node(String start_time, long sec_time, long count) {
            this.start_time = start_time;
            this.sec_time = sec_time;
            this.count = count;
        }

        public long getSec_time() {
            return sec_time;
        }

        public void setSec_time(long sec_time) {
            this.sec_time = sec_time;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }*/
}
