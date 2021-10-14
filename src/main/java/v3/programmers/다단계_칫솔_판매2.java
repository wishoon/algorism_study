package v3.programmers;

import java.util.HashMap;

public class 다단계_칫솔_판매2 {
    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        solution(enroll, referral, seller, amount);
    }

    // 판매원
    static HashMap<String, Integer> person = new HashMap<>();
    // 자식, 부모 키
    static HashMap<String, String> parent = new HashMap<>();

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for (int i = 0; i < enroll.length; i++) {
            person.put(enroll[i], 0);
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = person.get(enroll[i]);
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static void dfs(String name, int money) {
        if(name.equals("-") || money == 0) {
            return;
        }
        int benefit = (int)Math.ceil(money * 0.9);
        int tax = money - benefit;

        int holding_money = person.get(name);
        holding_money += benefit;
        person.put(name, holding_money);

        dfs(parent.get(name), tax);
    }

}
