package ThisCodingTest;

public class Sort4 {

    /*
    * 특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠르게 동작하는 정렬 알고리즘
    * 계수 정렬은 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때 사용 가능
    * 데이터의 개수가 N, 데이터(양수) 중 최댓갓이 K일 때 최아그이 경우에도 수행 시간 O(N + K)를 보장
    * -> 데이터의 범위가 너무 클 경우에는 사용 x
    * -> 동일한 값을 가지는 데이터가 여려 개 등장할 때 효과적으로 사용 (ex. 성적의 경우 100점을 맞은 학생이 여려 명일 수 있기 때문에 계수 정렬이 효과적으로 사용)
    */

    public static final int MAX_VALUE = 9;
    public static void main(String[] args) {
        int n = 15;

        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1;
        }
        for (int i = 0; i <= MAX_VALUE ; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
