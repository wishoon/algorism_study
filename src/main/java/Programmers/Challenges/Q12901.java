package Programmers.Challenges;

public class Q12901 {

    public static void main(String[] args) {
        int count = 5;
        int a = 5;
        int b = 24;
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int want_day = 0;
        String answer;
        String[] year = new String[366];

        // 달력
        for(int i=0; i<year.length; i++) {
            year[i] = day[(i+5)%7];
        }

        // 내가 입력한 달 이전까지는 더함
        for (int i = 0; i < a - 1; i++) {
            want_day += month[i];
        }

        want_day += b - 1;
        answer = year[want_day];

        System.out.println(answer);
    }
}
