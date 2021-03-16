package v2.Programmers;

public class 스킬트리 {

    public static void main(String[] args) {
        String skill = "CBD";
        String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
        int temp = solution(skill, skill_trees);

        System.out.println(temp);
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skill_len = skill.length();

        int len = skill_trees.length;   // 유저들의 스킬트리 갯수

        for (int i = 0; i < len; i++) {
            char[] skill_user = skill_trees[i].toCharArray();
            int skill_user_len = skill_user.length;
            int index = 0;
            boolean flag = true;
            for (int j = 0; j < skill_user_len; j++) {

                for (int k = index; k < skill_len; k++) {
                    if(skill.charAt(k) == skill_user[j]) {
                        if(k != index) {
                            flag = false;
                        } else {
                            index++;
                        }
                    }
                }
            }
            if(flag == true)
                answer++;
        }

        return answer;
    }
}
