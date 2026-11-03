class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(0,cost),dfs(1,cost));
    }

    public int dfs(int i, int[] cost){
        if(i>=cost.length){
            return 0;
        }
        return cost[i] + Math.min(dfs(i+1,cost),dfs(i+2,cost));
    }
}
