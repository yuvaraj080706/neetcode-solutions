class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1){
            return cost[0];
        }
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        dfs(0,cost,dp);
        return Math.min(dp[0],dp[1]);
    }

    public int dfs(int i, int[] cost,int[] dp){
        if(i >= cost.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(dfs(i+1,cost,dp),dfs(i+2,cost,dp));
        return dp[i];
    }
}
