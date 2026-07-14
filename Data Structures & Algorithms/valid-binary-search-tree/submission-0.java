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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        boolean left = true;
        if(root.left!=null){
            left = root.val > root.left.val && isValidBST(root.left);
        }

        boolean right = true;
        if(root.right!=null){
            right = root.val < root.right.val && isValidBST(root.right);
        }

        return left && right;

    }
}
