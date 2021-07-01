package v2.Programmers;

public class 비밀지도 {
    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        solution(n, arr1, arr2);

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        boolean[][] arr = new boolean[n][n];

        arr = binaryChange(n, arr, arr1);

        arr = binaryChange(n, arr, arr2);

        String[] answer = new String[5];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {

                if(arr[i][j] == false) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private static boolean[][] binaryChange(int n, boolean[][] arr, int[] arr1) {

        for (int i = 0; i < arr1.length; i++) {
            String a2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            for (int j = 0; j < a2.length(); j++) {
                if(a2.charAt(j) - '0' == 0) {
                    if(arr[i][j] == true)
                        continue;

                    arr[i][j] = false;
                } else
                    arr[i][j] = true;
            }
        }
        return arr;
    }
}
