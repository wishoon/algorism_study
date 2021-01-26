package Programmers.Kakao;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q72410 {
    public static void main(String[] args) {
        //        String[] exclaim =  {"-","_",".","~","!","@","#","$","%","^","&","*","(",")","=","+","[","{","]","}",":","?",",","<",">","/"};
        // 아이디의 길이는 3~15
        // 아이디는 알파벳 소문자, 숫자, -, _, . 만 사용가능
        // .은 처음과 끝에 사용불가 .. 연속은 불가가

        String new_id = "abcdefghijklmn.p";

        String answer = "";

        Deque<Character> id = new ArrayDeque<>();
        Deque<Character> answer_id = new ArrayDeque<>();

        // 대문자를 변경하는 로직
        String str = new_id.toLowerCase();
        // 지정된 문자 이외에 문자 제거
        for (int i = 0; i < str.length() ; i++) {
            char temp = str.charAt(i);

            if('a' <= temp && temp <= 'z'){
                id.add(temp);
            } else if('0' <= temp && temp <= '9'){
                id.add(temp);
            } else if('-' == temp || '_' == temp || '.' == temp){
                id.add(temp);
            }
        }

        char prev = id.poll();
        answer_id.offer(prev);

        while (!id.isEmpty()) {
            char ch = id.poll();
            if (ch == '.' && ch == prev) {
                continue;
            } else {
                answer_id.offer(ch);
            }
            prev = ch;
        }

        // 아이디의 처음에 위치한 . 제거
        if (answer_id.size() == 1) {
            if (answer_id.peekFirst() == '.') {
                answer_id.pollFirst();
            }

        } else if (answer_id.size() > 1) {
            if(answer_id.peekFirst() == '.'){
                answer_id.pollFirst();
            }
            if(answer_id.peekLast() == '.') {
                answer_id.pollLast();
            }
        }


        // 아이디에 빈 문자열 있을 시 a 대입
        if(answer_id.size() == 0){
            answer_id.offer('a');
        }
        // 사이즈가 16자 이상이면 15자 까지 지름
        if(answer_id.size() >= 16) {
            while (answer_id.size() != 15) {
                answer_id.pollLast();
            }

            if (answer_id.peekLast() == '.') {
                answer_id.pollLast();
            }
        }
        // 사이즈가 2자 이하라면 마지막 문자를 전체 사이즈가 3이 될때까지 반복
        if(answer_id.size() <= 2) {
            while (answer_id.size() < 3) {
                answer_id.offer(answer_id.peekLast());
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!answer_id.isEmpty()){
            sb.append(answer_id.poll());
        }

        answer = sb.toString();

        System.out.println(answer);
    }

}
