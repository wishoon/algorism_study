package ThisCodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Implementation4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int number = 0;
        ArrayList<Character> alpha = new ArrayList();

        for(int i=0; i<str.length(); i++){
            // 알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(str.charAt(i))) {
                alpha.add(str.charAt(i));
            }
            else {
                number += str.charAt(i) - '0';
            }
        }

        Collections.sort(alpha);

        for(int i=0; i<alpha.size(); i++){
            System.out.print(alpha.get(i));
        }
        System.out.print(number);
        System.out.println();
    }
}
