package BackJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        ArrayList<Integer> score = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            score.add(input.charAt(i) - '0');
        }
        Collections.sort(score, Comparator.reverseOrder());

        for (Integer integer : score) {
            System.out.print(integer);
        }
    }
}
