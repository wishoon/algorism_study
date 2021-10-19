package v3.implemention;


public class Q4673 {
    public static void main(String[] args) {

        boolean[] check = new boolean[100001];
        for (int i = 1; i <= 10000; i++) {
            int n = self_number(i);
            check[n] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if(!check[i]) {
               sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int self_number(int n) {
        int sum = n;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
