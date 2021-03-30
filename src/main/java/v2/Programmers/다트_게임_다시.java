package v2.Programmers;

public class 다트_게임_다시 {
    public static void main(String[] args) {

        String dartResult = "1S2D*3T";
        solution(dartResult);
    }

    public static int solution(String dartResult) {

        int answer = 0;
        int[] score = new int[3];
        char[] darts = dartResult.toCharArray();

        int cnt = -1;
        for (int i = 0; i < darts.length; i++) {

            if (darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if(darts[i] == '1' && darts[i + 1] == '0') {
                    i++;
                    score[cnt] = 10;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if(darts[i] == 'S') {
                score[cnt] *= 1;
            } else if(darts[i] == 'D') {
                score[cnt] *= score[cnt];
            } else if(darts[i] == 'T') {
                score[cnt] *= score[cnt] * score[cnt];
            } else if(darts[i] == '*') {
                if(cnt > 0) {
                    score[cnt - 1] *= 2;
                }
                score[cnt] *= 2;
            } else if(darts[i] == '#') {
                score[cnt] *= -1;
            }
        }

        answer = score[0] + score[1] + score[2];

        return answer;
    }
}
