/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        helper(root.left, root.right);
        return root;
    }


    private void helper(TreeNode left, TreeNode right){
        if(left!=null && right!=null){
            int leftVal = left.val;
            int rightVal = right.val;

            left.val = rightVal;
            right.val = leftVal;

            helper(left.left,right.right);
            helper(left.right,right.left);
        }
    }
}
