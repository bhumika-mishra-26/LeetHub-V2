class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;

        }
        if (sum % 2 != 0)//agar divide nhi ho rha h to pakka false hi hoga 
            return false;
        int amount = sum / 2;
        // har ek subset ka sum 
        boolean[][] dp = new boolean[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;

        }
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = false;

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];

            }
        }

        return dp[n][amount];

    }
}