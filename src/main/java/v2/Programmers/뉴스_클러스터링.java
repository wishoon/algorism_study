package v2.Programmers;

import java.util.ArrayList;

public class 뉴스_클러스터링 {
    public static void main(String[] args) {

        String str1 = "FRANCE";
        String str2 = "french";

        int answer = solution(str1, str2);
        System.out.println(answer);
    }

    public static int solution(String str1, String str2) {
        /*
        * 일단 str1, str2를 사용해 2글자로 만들수 있는 조합을 구한다.*/

        ArrayList<String> twice1 = new ArrayList<>();
        ArrayList<String> twice2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                twice1.add(first + "" + second);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                twice2.add(first + "" + second);
            }
        }

        for (String s : twice1) {
            if(twice2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        for (String s : twice2) {
            union.add(s);
        }

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }
}
