package v2.Programmers;

public class 다트_게임 {
    public static void main(String[] args) {

        String dartResult = "1S2D*3T";
        solution(dartResult);
    }

    /*
    * 1. S는 1제곱, D는 2제곱, T는 3제곱으로 구분
    * 2. 옵션이 있을수도 있고 없을 수도 있음.
    *   2.1 *은 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
    *   2.2 #은 해당 점수를 마이너스화 한다.
    *   2.3 **, *#, 이렇게 중첩이 될 수 있다(연속적으로 올 수 있다는 말이 아님!!)
    * */
    public static int solution(String dartResult) {

        // 1~10부터 숫자를 구분
        // S,D,T숫자를 구분
        // *, # 기호를 구분

        int length = dartResult.length();
        int index = 0;

        int answer = 0;
        int score = 0;
        int score_log = 0;
        int score_log_log = 0;

        while (index != length) {
            char c = dartResult.charAt(index);

            if(0 <= c - '0' || c <= 10 - '0') {
                score = c - '0';
            } else if(c == 'S' || c == 'D' || c == 'T') {
                if (c == 'S') {
                    score = score;
                } else if (c == 'D') {
                    score *= score;
                } else if (c == 'T') {
                    score = score * score * score;
                }

                if (index + 1 != length) {
                    c = dartResult.charAt(index + 1);
                    System.out.println(c);
                    if (c == '*' || c == '#') {
                        if (c == '*') {
                            answer -= score_log;
                            score_log *= 2;
                            answer += score_log;
                            score *= 2;
                        } else {
                            score *= -1;
                        }
                    }
                    index++;
                }
            }
            answer += score;
            score_log = score;
            index++;
            System.out.println(answer);
            System.out.println("===");
        }


        System.out.println(answer);
        return answer;
    }
}
