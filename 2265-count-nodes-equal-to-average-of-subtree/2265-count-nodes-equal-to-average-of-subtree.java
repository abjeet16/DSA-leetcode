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
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null)return 0;
        find(root);
        return res;
    }
    private int[] find(TreeNode root){
        if(root == null)return new int[]{0,0};

        int[] left = find(root.left);
        int[] right = find(root.right);
        int sum =  left[0]+right[0]+root.val;
        int count = left[1]+right[1]+1;
        if(sum/count==root.val)res++;
        return new int[]{sum,count};
    }
}