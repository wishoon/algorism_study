package v2.Programmers;

public class 프124_나라의_숫자 {
    public static void main(String[] args) {

        solution(513);
    }

    public static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while(num > 0){
            int remainder = num % 3;
            num /= 3;

            if(remainder == 0) num--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}

