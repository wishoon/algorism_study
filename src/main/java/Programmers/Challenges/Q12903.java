package Programmers.Challenges;


public class Q12903 {

    public static void main(String[] args) {
        String s = "abcde";
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();

        int size = s.length();
        int middle = size/2;
        if (size % 2 == 1){
            sb.append(cs[middle]);
        } else {
            sb.append(cs[middle-1]);
            sb.append(cs[middle]);
        }
        answer = sb.toString();
    }
}
