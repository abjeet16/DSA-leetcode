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
    public int sumNumbers(TreeNode root) {
        return find(root,0);
    }
    private int find(TreeNode root,int sum){
        sum = sum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        int left = 0;
        if(root.left!=null)
            left = find(root.left,sum);
        int right = 0;
        if(root.right!=null)
            right = find(root.right,sum);
        return left+right;
    }
}