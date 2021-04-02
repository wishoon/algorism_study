package v2.Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
    public static void main(String[] args) {

        String msg = "KAKAO";
        solution(msg);
    }

    public static void solution(String msg) {

        /*
        * 1. HashMap을 통해 문자열, 숫자 데이터를 입력 받도록 설정(A,B,C,D...)
        * 2. containsAllKey로 해당 문자열이 있는지를 조회
        * 2.1 있으면 계속 문자 인덱스를 +1해주면서 조회
        * 2.2 없는 값이 나왔을 경우 map데이터에 새로 추가, 그 전값의 숫자를 answer 배열에 추가
        *
        * */
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        int number = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), number++);
        }

        int add = 27;

        int size = msg.length();

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            String word = msg.charAt(i)+"";

            while (map.containsKey(word)) {
                i++;
                if(i == size) {
                    flag = true;
                    break;
                }
                word += msg.charAt(i);
            }
            if(flag) {
                answer.add(map.get(word));
                break;
            }

            answer.add(map.get(word.substring(0, word.length() - 1)));
            map.put(word, add++);

            i--;
        }


        int[] answers = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            answers[i] = answer.get(i);
        }
    }
}

/*
* String temp = msg.substring(start, count);
            System.out.println(temp);
            if(map.containsKey(temp)) {
                answer.add(map.get(temp));
                count++;
            } else {
                answer.add(map.get(temp));
                map.put(temp, add++);
                start = count;
                count++;
            }*/