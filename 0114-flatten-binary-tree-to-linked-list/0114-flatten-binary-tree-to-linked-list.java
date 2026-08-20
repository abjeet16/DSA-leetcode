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
    TreeNode res = new TreeNode();

    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode right = root.right;
        res.right = root;
        res = res.right;

        flatten(root.left);
        flatten(right);

        root.left = null;
    }
}