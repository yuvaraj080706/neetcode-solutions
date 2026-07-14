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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null)    return true;
        if (s==null)    return false;

        if(sameTree(s,t))   return true;
        return sameTree(s.right,t) || sameTree(s.left,t);
    }

    private boolean sameTree(TreeNode p, TreeNode q){
        if(p==null && q==null)  return true;
        if(p!=null && q!=null && p.val == q.val){
            return sameTree(p.left,q.left) && sameTree(p.right,q.right);
        }
        return false;
    }
}
