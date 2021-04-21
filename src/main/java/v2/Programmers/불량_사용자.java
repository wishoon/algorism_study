package v2.Programmers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class 불량_사용자 {

    public static void main(String[] args) {

    }

    private static Set<Set<String>> result = new HashSet<>();

    public static int solution(String[] user_id, String[] banned_id) {

        dfs(user_id, banned_id, new LinkedHashSet<>());

        return result.size();
    }

    public static void dfs(String[] user_id, String[] banned_id, Set<String> set) {

        if(set.size() == banned_id.length) {
            if(isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
            return;
        }

        // 조합
        for (String id : user_id) {
            if(!set.contains(id)) {
                set.add(id);
                dfs(user_id, banned_id, set);
                set.remove(id);
            }
        }
    }

    // 조합 구성들이 불량 사용자랑 일치하는지 하나씩 검사
    private static boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;

        for (String user : set) {
            if(!isSameString(user, banned_id[i++])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameString(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if(b.charAt(i) == '*')
                continue;
            if(a.charAt(i) != b.charAt(i))
                return false;

        }
        return true;
    }
}

