package Inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : input2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) {
                System.out.println("NO");
                return;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println("YES");
    }
}
