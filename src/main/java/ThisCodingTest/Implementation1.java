package ThisCodingTest;

import java.util.Scanner;

public class Implementation1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 숫자 n을 입력하기
        int num = sc.nextInt();
        // 버퍼 비우기
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // 문자 L,R,U,D의 따른 이동 방향
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 후 좌표 구하기
        for(int i=0; i< plans.length; i++){
            int nx = -1, ny = -1;

            for(int j = 0; j<4;j++){
                char plan = plans[i].charAt(0); // String 형에서 char형으로 바꾸기
                if(plan == moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if(nx<1 || ny<1 || nx > num || ny > num){
                continue;
            }
            // 이동 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
