class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            while(nums[i]!= nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }

        for(int i=0; i<nums.length-1 ;i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }

        return 0;
    }
}
