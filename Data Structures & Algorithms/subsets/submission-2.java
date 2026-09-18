class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums,0,res,new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> sub){
        if(i==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        //add
        sub.add(nums[i]);
        backtrack(nums,i+1,res,sub);
        //remove
        sub.remove(sub.size()-1);
        backtrack(nums,i+1,res,sub);
    }
}
