package Inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 모든_아나그램_찾기 {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        int cnt = 0;

        Map<Character, Integer> mapB = new HashMap<>();
        for (char c : T.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> mapA = new HashMap<>();
        char[] c = S.toCharArray();
        for (int i = 0; i < T.length() - 1; i++) {
            mapA.put(c[i], mapA.getOrDefault(c[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = T.length() - 1; rt < S.length(); rt++) {
            mapA.put(c[rt], mapA.getOrDefault(c[rt], 0) + 1);
            if(mapB.equals(mapA)) {
                cnt++;
            }
            mapA.put(c[lt], mapA.get(c[lt]) - 1);
            if(mapA.get(c[lt]) == 0) {
                mapA.remove(c[lt]);
            }
            lt++;
        }
        System.out.println(cnt);
        
    }
}
