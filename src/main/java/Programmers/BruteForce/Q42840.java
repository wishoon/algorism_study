package Programmers.BruteForce;

import java.util.ArrayList;

public class Q42840 {
    public static void main(String[] args) {
        int[] answers = {};
        int[] answer = {};

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int answer1 = 0, answer2 = 0, answer3 = 0;
        int[] cnt = {};
        for(int i=0; i<answers.length; i++){

            if(person1[i%person1.length] == answers[i]) answer1++;
            if(person2[i%person2.length] == answers[i]) answer2++;
            if(person3[i%person3.length] == answers[i]) answer3++;
        }

        int max = Math.max(Math.max(answer1, answer2),answer3); // max값 구하기

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<3; i++){
            if(max == answer1) arr.add(1);
            if(max == answer2) arr.add(2);
            if(max == answer3) arr.add(3);
        }

        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
    }
}
//    String[] student = new String[3];
//    int[] answers = new int[5];
//    int[] answer_s = new int[3];
//
//
//        student[0] = "12345";
//                student[1] = "21232425";
//                student[2] = "3311224455";
//
//                for(int i = 0; i < 3; i++){
//        int k = 0;
//        for (int j = 0; j < answers.length; j++) {
//        if(k > student.length)
//        k = 0;
//        if(student[i].charAt(k) - '0' == answers[j])
//        answer_s[i]++;
//        k++;
//        }
//        }
//        int temp = 0;
//        String number = null;
//        for(int i = 0; i < 3; i++){
//        if(temp >= answer_s[i])
//        temp = answer_s[i];
//        }
//        for(int i = 0; i < 3; i++){
//        if(temp == answer_s[i])
//        number += i;
//        }
//        int[] answer = new int[number.length()];
//        for (int i = 0; i < number.length(); i++) {
//        answer[i] = number.charAt(i) - '0';
//        }