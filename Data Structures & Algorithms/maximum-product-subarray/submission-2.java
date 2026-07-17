class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = nums[0];

        for(int n : nums){
            int temp = n * max;
            max = Math.max(Math.max((n*max),(n*min)),n);
            min = Math.min(Math.min((n*min),(temp)),n);
            res = Math.max(res,max);
        }

        return res;
    }
}
