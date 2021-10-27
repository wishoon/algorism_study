package v3.programmers;


public class 소수_만들기_개정 {
    static int[] prime = new int[3001];
    public static void main(String[] args) {

        int[] nums = {1, 2, 7, 6, 4};

        int answer = solution(nums);
        System.out.println(answer);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        prime[0] = 1;
        prime[1] = 1;


        makePrime(3000);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean isPrime(int n) {
        if (prime[n] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void makePrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j < n; j = j + i) {
                    prime[j] = 1;
                }
            }
        }
    }
}
