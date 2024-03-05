import java.util.Scanner;

class dp1 {

    // Fibonacci number dp program
    public static int Fib(int n, int dp[]) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = Fib(n - 1, dp) + Fib(n - 2, dp);

        return dp[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the fibonacci:");
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        System.out.println("OutPut is the : " + Fib(n, dp));

    }
}