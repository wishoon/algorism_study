package v3.programmers;

import java.util.Arrays;

public class 숫자_게임 {

    public static void main(String[] args) {

        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        int answer = solution(A, B);
        System.out.println(answer);
    }

    public static int solution(int[] A, int[] B) {

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int B_index = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = B_index; j < B.length; j++) {
                if (A[i] < B[j]) {
                    B_index = j + 1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
