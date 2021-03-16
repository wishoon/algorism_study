package v2.Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class 추석_트래픽_다시풀어야함 {

    public static void main(String[] args) throws ParseException {

        String[] lines = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};

        int temp = solution(lines);
        System.out.println(temp);
    }

    public static int solution(String[] lines) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] timeCounter = new int[24 * 60 * 60 * 1000 + 1];
        long baseMills;

        baseMills = format.parse("00:00:00.000").getTime();

        for (int idx = 0; idx < lines.length; idx++) {
            String[] log = lines[idx].split(" ");
            // 시간 형식을 int 형으로 변경.
            int endMillis = (int) (format.parse(log[1]).getTime() - baseMills);
            int processMillis = (int) Math.round(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
//            System.out.println(format.format(processMillis));
            int startMillis = endMillis - processMillis + 1;

            // 시작 time을 1초씩 체크해서 millis 배열에 추가  (예외로 이전날에 갈 가능성이 있기 때문에 0입력 부분도 처리)
            for (int time = Math.max(startMillis- 999, 0); time <= endMillis; time ++) {
                timeCounter[time]++;
            }
        }

        return Arrays.stream(timeCounter).max().orElse(0);
    }
}

/**
 * 1. 시와 분을 그리고 초를 기준으로 배열을 생성 --> 시분초를 초로 전부 환산시키기
 * 2. 주어지는 초와 처리시간을 뺄샘하여 처음과 끝 찾기
 * 3. 반복문을 돌며 +1 초씩 더해 해당하는지 해당 열에 포함되는지 확인해보기
 * 4. 포함시 그 배열에 count++ 처리
 * 5. 지정된 입력을 다 돌면 최종 값 출력하기
 * */
