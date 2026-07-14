class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 1;
        while(r<n){
            if(nums[l] == nums[r] && (r-l) <= k){
                return true;
            }
            else if((r-l)>k){
                l++;
            }
            else{
                r++;
            }
        }
        return false;
    }
}