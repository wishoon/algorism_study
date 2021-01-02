package ThisCodingTest;

import java.util.Scanner;

public class Greedy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // String 내부의 특정문자에 접근하기 위하여 charAt()을 사용
        // 첫 번째 문자를 숫자로 변경한 값을 대입 (모든 문자에서 '0'을 빼주면 숫자로 변환된다.)
        long result = input.charAt(0) - '0';

        for(int i = 1; i < input.length(); i++){

            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = input.charAt(i) - '0';
            if(num<=1 || result<=1){
                result += num;
            }
            else {
                result *= num;
            }
        }
        System.out.println(result);
    }
}
