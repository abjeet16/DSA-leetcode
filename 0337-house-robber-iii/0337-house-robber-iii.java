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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> memo = new HashMap<>();
        return find(root,memo);
    }
    private int find(TreeNode root,HashMap<TreeNode,Integer> memo){
        if(root==null)return 0;
        if(memo.containsKey(root))return memo.get(root);
        int rob = root.val;
        if(root.left!=null){
            rob+=find(root.left.left,memo)+find(root.left.right,memo);
        }
        if(root.right!=null){
            rob+=find(root.right.left,memo)+find(root.right.right,memo);
        }
        int dontRob = find(root.left,memo)+find(root.right,memo);
        int ans = Math.max(rob,dontRob);
        memo.put(root,ans);
        return ans;
    }
}