package v3.programmers;

import java.util.HashMap;

public class 다단계_칫솔_판매 {
    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = solution(enroll, referral, seller, amount);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    // 판매원, 총 금액
    static HashMap<String, Integer> person = new HashMap<>();
    // 자식, 부모
    static HashMap<String, String> connect = new HashMap<>();

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // enroll 판매원의 이름을 담은 배열
        // referral 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열
        // seller 판매량 집계 데이터의 판매원 이름을 나열한 배열
        // refund 가격 배열

        for (int i = 0; i < enroll.length; i++) {
            person.put(enroll[i], 0);
            connect.put(enroll[i], referral[i]);
        }

        // 판 사람에 대한 정산 실시
        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = person.get(enroll[i]);
        }
        return answer;
    }

    public static void dfs(String name, int money) {
        // center 이거나 세금이 0인 경우 제귀 종료
        if(name.equals("-") || money == 0) {
            return;
        }
        int benefit = (int)Math.ceil(money * 0.9);
        int tax = money - benefit;

        // 현재 판 사람의 90 수익금 저장
        person.replace(name, person.get(name) + benefit);
        // 현재 판 사람의 추천인(부모) 검색
        String parent = connect.get(name);
        // dfs로 부모 이동 및 세금 전달
        dfs(parent, tax);
    }
}

