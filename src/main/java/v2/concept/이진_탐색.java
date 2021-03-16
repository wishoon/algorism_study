package v2.concept;

import java.util.Scanner;

public class 이진_탐색 {

    /**
     * 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
     * -> 이진 탐색은 시작점, 끝점, 중간점을 이용하여 탐색 범위를 설정
    * */

    /*
        1. 시작점, 끝점, 중간점:(소수점 이하 제거)
        2. 중간점이 찾고자 하는 수보다 크면 중간점을 끝점으로 바꾸고 다시 1을 수행
        3. 중간점이 찾고자 하는 수보다 크면 중간점을 시작점으로 바꾸고 다시 1을 수행
     */

    // 예시 코드
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else
                start = mid + 1;
        }
        return -1;
    }

    /*
        만약 중복된 값을 찾아야 할 경우 발생시 lowerBound, upperBound를 구현하여서 문제를 풀어야 한다
        차이점을 작성하면
        1. 탐색 범위를 0 ~ list.length - 1이 아닌 0 list.length 까지로 설정
        2. while문의 조건문이 left <= right가 아닌 left < right
        3. 왼쪽 절반으로 탐색 범위를 줄일 때 right = mid
        4. left값을 번환한다.
    */



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];

        int result = binarySearch(arr, target, 0, n - 1);

    }
}
