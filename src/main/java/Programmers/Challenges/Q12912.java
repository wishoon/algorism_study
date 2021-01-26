package Programmers.Challenges;

public class Q12912 {
    public static void main(String[] args) {

        // 1차 풀이
        int A = -3;
        int B = 3;

        long temp = 0;
        long next = 0;
        if(A == B) {
            temp = A;
        }
        else if(A < B){
            temp = A;
            next = temp;
            while(true){
                System.out.println(temp);
                if(A == B)
                    break;
                temp += next+1;
                next+=1;
                A++;
            }
        } else {
            temp = B;
            next = temp;
            while(true) {
                System.out.println(temp);
                if (A == B)
                    break;
                temp += next + 1;
                next+=1;
                B++;
            }
        }

        System.out.println(temp);

        int a = 0;
        int b = 0;

        // 2차 풀이
        long answer = 0;

        if (a < b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
        } else {
            for (int i = b; i <= a; i++) {
                answer += i;
            }
        }
        System.out.println(answer);
    }
}
