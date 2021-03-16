package v2.Programmers;

public class 괄호_변환_성공 {

    public static int cnt = 0;

    public static void main(String[] args) {
        String p = ")(";
        System.out.println(solution(p));
    }

    public static String solution(String p) {

        StringBuilder sb = new StringBuilder();

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.isEmpty()) {
            return "";
        }

        // 2. 문자열 p를 균형잡힌 괄호 문자열 u,v로 분리합니다.\
        int index = strJudge(p);

        String u = p.substring(0, index);
        String v = p.substring(index);
        // 3. u가 올바른 괄호 문자열일 경우 문자열 v 부터 다시 1단계 수행
            // 3.a 다시 수행한 결과 문자열을 u에 붙인 후 반환
        if(strProve(u)) {
            return u + solution(v);
        } else {
            // 3.b 만약 u가 올바른 괄호 문자열이 아닌 경우 다음을 수행
                // 3.b.1 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            sb.append('(');
                // 3.b.2 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            sb.append(solution(v));
            sb.append(')');
            sb.append(u_removeAndSwap(u));
        }
        return sb.toString();
    }

    private static String u_removeAndSwap(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if(i == 0 || i == u.length() - 1){
                continue;
            } else {
                if(u.charAt(i) == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }
        }
        return sb.toString();
    }

    private static boolean strProve(String u) {
        int count = 0;

        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(')
                count++;
            else {
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return true;
    }

    private static int strJudge(String p) {

        int count = 0;
        int index = 1;

        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                count++;
            else
                count--;

            if(count == 0) {
                index += i;
                break;
            }
        }
        return index;
    }
}
