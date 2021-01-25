package Programmers.Greedy;

public class Q42862 {

    public static void main(String[] args) {
        int n = 9;
        int[] lost = {2, 4, 7, 8};
        int[] reserve = {3, 6, 9};

        // 먼저 도난 학생과 여별 학생 일치 여부를 확인
        // 일치 학생은 배열에서 제거
        // 이후 -1, +1을 통해서 근처 학생 일치 여부를 확인

        int[] all = new int[n];

        for (int i : reserve)
            all[i - 1]++;

        for (int i : lost)
            all[i - 1]--;

        for (int i = 0; i < all.length; i++)
            if (all[i] < 0)
                if (i != all.length - 1 && all[i + 1] > 0) {
                    all[i]++;
                    all[i + 1]--;
                } else if (i != 0 && all[i - 1] > 0) {
                    all[i]++;
                    all[i - 1]--;
                }

        int answer = 0;

        for (int i = 0; i < all.length; i++)
            if (!(all[i] < 0))
                answer++;

        System.out.println(answer);
    }
}
