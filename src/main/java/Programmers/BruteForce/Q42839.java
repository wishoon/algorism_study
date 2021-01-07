package Programmers.BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Q42839 {

    private static TreeSet<String> set = new TreeSet<>();
    private static int count;

    public static void main(String[] args) {
        String numbers = "17";

        int size = numbers.length();

        // 리스트에 숫자들을 담아줌
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(numbers.charAt(i));
        }

        // 결과를 저장할 리스트
        List<Character> result = new ArrayList<>();

        // 순열을 사용하여 전체 리스트를 조회
        for(int i=0; i < size; i++){
            permutation(list, result, size, i + 1);
        }
    }

    public static void permutation(List<Character> list, List<Character> result, int n, int r){
        if(r == 0){
            if(list.get(0) != '0'){
                String str = "";
                int size = result.size();
                for (int i = 0; i < size; i++) {
                    str += result.get(i);
                }
                int num = 0;

                if(!set.contains(str)){
                    num = Integer.parseInt(str);
                    set.add(str);
                    if(isPrime(num)){
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result.add(list.remove(i));
            permutation(list, result, n - 1, r - 1);
            list.add(result.remove(result.size()-1));
        }
    }

    public static boolean isPrime(int num){
        int i;
        int sqrt = (int)Math.sqrt(num);

        if(num == 2)
            return true;
        if(num % 2 == 0 || num == 1)
            return false;
        // 제곱근까지만 홀수로 나눠보면 됨
        for (i = 3; i <= sqrt; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}