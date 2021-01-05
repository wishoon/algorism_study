package ThisCodingTest;

public class Sort3 {

    /*
        퀵 정렬 : 기존 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치르 바꾸는 방법.
        일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나입니다.
        병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘입니다.
        가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(Pivot)로 설정합니다.

        데이터 5,7, 9, 0, 3, 1, 6, 2, 4, 8
        1. 현재 피벗의 값은 5이다. 왼쪽에서부터 '5'보다 큰 데이터를 선택하므로 '7'이 선택되고, 오른쪽에서부터 '5'보다 작은 데이터를 선택하므로 '4'가 선택됩니다.
        2. 이제 이 두 데이터의 위치를 서로 변경
        3. 이후 계속 1,2를 실행
        4. 실행 도중 왼쪽이 큰 값 오른쪽이 작은 값이 아니라 왼쪽이 작은 값 오른쪽이 큰값이 되는 경우 피벗(5)와 작은 데이터의 위치를 서로 변경합니다.
        5. 이제 '5'의 왼쪽에 있는 데이터는 모두 5보다 작고, 오른쪽에 있는 데이터는 모두 '5'보다 크다는 특징이 있습니다. 이렇게 피벗을 기준으로 데이터 묶음을 나누는 작업을
        분할이라고 합니다.

        6. 왼쪽에 데이터 묶음 정렬을 마찬가지로 위와 같이 처음처럼 실행한다. (오른쪽도 마찬가지) -> 즉, 재귀적!!!!!!

        퀵 정렬이 빠른 이유 : 이상적인 경우 분할이 절반씩 일어난다면 전체 연산 횟수로 O(NlogN)을 기대할 수 있다.
        But, 최악의 경우 O(N의 제곱)의 시간 복잡도를 가진다.
        -> 첫 번째 원소를 피벗으로 삼을 때, 이미 정렬된 배열에 대해서 퀵 정렬을 수해앟면 어떻게 될까??
   */

    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;    // 원소가 1개인 경우 종료
        int pivot = start;  // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;
        while(left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;
            // 피벗보다 작은 데이터르르 찾을 때까지 반복
            while(right > start && arr[right] >= arr[pivot]) right--;
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0 , n - 1);
    }
}

