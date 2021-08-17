package Inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급_회장 {

    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char answer = 0;
        int max = Integer.MIN_VALUE;
        for (char k : map.keySet()) {
            if(map.get(k) > max) {
                max = map.get(k);
                answer = k;
            }
        }
        System.out.println(answer);
        
        // map.containsKey('A') : A라는 글자가 map의 키 값에 존재하는 가? (true, false)
    }
}
