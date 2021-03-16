package v2.Programmers;

public class 문자열_압축_복습필요 {
    public static void main(String[] args) {
        String s = "a";
        solution(s);
    }

    public static void solution(String s) {
        int answer = Integer.MAX_VALUE;

        if (s.length() == 1){
            System.out.println(1);
        }
        for (int i = 1; i <= s.length() / 2 ; ++i) {
            int len = s.length();
            int pos = 0;
            for (; pos + i <= s.length();) {
                String word = s.substring(pos, pos + i);
                pos+= i;
                int cnt = 0;
                for (; pos + i <= s.length();) {
                    if(word.equals(s.substring(pos, pos + i))){
                        ++cnt;
                        pos += i;
                    } else {
                        break;
                    }
                }
                if(cnt > 0) {
                    len -= i * cnt;

                    if(cnt < 9)
                        len += 1;
                    else if(cnt < 99)
                        len += 2;
                    else if(cnt < 999)
                        len += 3;
                    else
                        len += 4;
                }
                System.out.println(len);
                answer = Math.min(answer, len);
            }
        }

        System.out.println(answer);
    }
}
