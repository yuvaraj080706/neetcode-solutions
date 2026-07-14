class Solution {
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        return dfs(0);
    }

    private int dfs(int i){
        if(i>=nums.length){
            return 0;
        }
        return Math.max((nums[i] + dfs(i+2)),dfs(i+1));
    }
}
