class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums,0,n-1)), helper(Arrays.copyOfRange(nums,1,n)));
    }

    private int helper(int[] nums){
        int rob1 = 0, rob2 = 0;

        for(int r : nums){
            int temp = Math.max(rob1+r, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
