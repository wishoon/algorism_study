package v2.Programmers;

public class 키패드_누르기 {
    public static void main(String[] args) {

    }

    static int[][] hands =  {
            {' ', '1', '2', '3'},
            {' ', '4', '5', '6'},
            {' ', '7', '8', '9'},
            {' ', '*', '0', '#'}
    };
    public static String solution(int[] numbers, String hand) {

        /*
        * 맨 처음 왼손 엄지손가락은 *, 맨 처음 오른손 엄지손가락은 # 키패드 위치에서 시작하며 다음의 규칙을 따른다.
        * 1. 키패드 이동 한 칸은 거리로 1에 해당
        * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼쪽 엄지손가락을 사용
        * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른속 엄지손가락을 사용
        * 4. 가운데 열의 2, 5, 8, 0은 두 손가락 중 가까운 손가락을 클릭
        *   4.1 이와중에 거리가 같다면 어느 손잡인지에 따라서 클릭*/



        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;

        int dl = 0, dr = 0;

        for (int number : numbers) {

            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;
                continue;
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;
                continue;
            }

            if(number == 0)
                number = 11;

            dl = Math.abs((left -  number) / 3) + Math.abs((left - number) % 3);
            dr = Math.abs((right -  number) / 3) + Math.abs((right - number) % 3);

            if(dl < dr) {
                sb.append("L");
                left = number;
            } else if(dl > dr) {
                sb.append("R");
                right = number;
            } else if(dl == dr) {
                if(hand.equals("left")){
                    sb.append("L");
                    left = number;
                } else {
                    sb.append("R");
                    right = number;
                }
            }
        }

        String answer = sb.toString();
        return answer;
    }

}
