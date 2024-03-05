public class o_l_knapsak {

    // 0-1 knapsak code for recursive && memoisation technique

    //time complexty O(n*w)
    //in recursion the time complexty => O(2^n)
    public static int knapsak(int val[], int wt[], int w, int n, int dp[][]) {

        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) { // valid case

            // Incluuded
            int ans1 = val[n - 1] + knapsak(val, wt, w - wt[n-1], n - 1, dp);
            // Excluded
            int ans2 = knapsak(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else { // not vailed case
            dp[n][w] = knapsak(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int[][] dp = new int[val.length+1][w + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsak(val, wt, w, val.length, dp));

    }

}
