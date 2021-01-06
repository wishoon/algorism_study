package Programmers.Sort;

import java.io.IOException;
import java.util.Arrays;

public class Q42747 {
    public static void main(String[] args) throws IOException {
        int[] citations = {3, 0, 6, 1, 5};

        solution(citations);
    }

    public static void solution(int[] citations) throws IOException {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++){
            int h = citations.length - i;

            if(citations[i] >= h){
                answer = h;
                break;
            }
        }

    }
}


//    int h = 0;
//    int up = 0;
//    int down = 0;
//        for(int i = 0; i < citations.length; i++){
//        up = 0;
//        down = 0;
//        int temp = citations[i];
////            System.out.println(temp);
//        for(int k = 0; k < citations.length; k++){
//
//        if(temp <= citations[k]){
//        up++;
//        }
//        if(temp >= citations[k]){
//        down++;
//        }
//        }
//        System.out.println("up" + up);
//        System.out.println("down" + down);
//        if(up == down){
//        if(h < up)
//        h = up;
//        }
//        }
//
//        System.out.println(h);