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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        find(res,new ArrayList<>(),root,target);
        return res;
    }
    private void find(List<List<Integer>> res,ArrayList<Integer> curr,TreeNode root,int target){
        if(root==null)return;
        target-=root.val;
        curr.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==0)res.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        find(res,curr,root.left,target);
        find(res,curr,root.right,target);
        curr.remove(curr.size()-1);
    }
}