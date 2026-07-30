class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums,0,0);
    }

    private int dfs(int[] nums, int i, int total){
        if(i == nums.length){
            return total;
        }

        //add
        int add = dfs(nums,i+1, nums[i]^total);
        //skip
        int skip = dfs(nums,i+1,total);

        return add + skip;
    }
}