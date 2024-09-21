class Main {
    static int countWays(int[] arr, int N, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int element : arr) {
            for (int sum_val = target; sum_val >= element; sum_val--) {
                for (int count = 1; count <= N; count++) {
                    if (sum_val - count * element >= 0) {
                        dp[sum_val] += dp[sum_val - count * element];
                    }
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = { 100, 200, 500 };
        int N = 5;
        int target = 1000;
        int output = countWays(arr, N, target);
        System.out.println("Number of ways to achieve the target: " + output);
    }
}