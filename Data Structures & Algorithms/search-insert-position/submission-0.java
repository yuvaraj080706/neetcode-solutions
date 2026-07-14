class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = n;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid + 1;
            }
            else if(nums[mid]>target){
                res = mid;
                r = mid - 1;
            }
            else{
                return mid;
            }
        }

        return res;
    }
}