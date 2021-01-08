package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15650 {

    static TreeSet<String> arr = new TreeSet<>();

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=1; i<=N; i++){
            list.add(i);
        }
        permutation(list, result, N, M);
    }

    public static void permutation(List<Integer> list, List<Integer> result, int n, int r){

        if(r == 0){
            String str = " ";
            List<Integer> copy = new ArrayList<>();
            copy.addAll(result);
            Collections.sort(copy);

            for(int i=0; i<copy.size(); i++){
                str += copy.get(i);
            }

            if(!arr.contains(str)){
                arr.add(str);
                for(int i=0; i<result.size(); i++){
                    System.out.print(result.get(i) + " ");
                }
                System.out.println();
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            result.add(list.remove(i));
            permutation(list, result, n-1, r-1);
            list.add(i, result.remove(result.size() - 1));
        }
    }
}
