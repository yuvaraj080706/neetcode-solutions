class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(r<nums.length){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res,(r-l+1));
                l++;
                sum -= nums[l];
            }
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}