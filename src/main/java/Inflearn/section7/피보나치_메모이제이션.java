package Inflearn.section7;

public class 피보나치_메모이제이션 {

    static int[] arr;
    public static void main(String[] args) {

        arr = new int[10];
        arr[0] = 0;
        arr[1] = arr[2] = 1;

        dfs(9);

        for (int i = 1; i <= 9; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int dfs(int n) {
        if(arr[n] != 0) {
            return arr[n];
        }
        if (n == 1 || n == 2)
            return 1;

        return arr[n] = dfs(n - 1) + dfs(n - 2);
    }
}
