package ThisCodingTest;

public class Sort {

    /*선택 정렬 - 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것을 반복한다.
        1. 처리되지 않은 데이터 중 가장 작은 데이터를 선택해 가장 앞에 있는 데이터와 바꿉니다.
        2. 처리되지 않은 데이터 중 가장 작은 데이터를 선택해 가장 앞에 있는 데이터와 바꿉니다. ... 반복

        시간 복잡도 : 선택 정렬은 N번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 한다.
                    구현 방법에 따라서 사소한 오차는 있을 수 있으나, N의 2제곱이 보통이다.*/
    public static void main(String[] args) {

        // 선택 정렬
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i = 0; i < n; i++){
            int min_index = i;
            for(int j = i+1; j < n; j++){
                if(arr[min_index] > arr[j]){
                    min_index = j;
                }
            }
            // 스와프
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
