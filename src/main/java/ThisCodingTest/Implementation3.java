package ThisCodingTest;

import java.util.Scanner;

public class Implementation3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        // 자바에서는 문자열을 chartAt(index)를 통하여 특정한 문자열을 가져올 수 있다.
        int column = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';

        int result = 0;
        int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        for(int i=0; i<8; i++){
            // 이동하고자 하는 위치 확인
            int newRow = row + dx[i];
            int newCol = column + dy[i];

            if(newRow >= 1 && newRow <= 8 && newCol >= 1 && newRow <= 8 ){
                result++;
            }
        }
        System.out.println(result);
    }
}
