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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        form(res,root,1);
        return res;
    }
    private void form(List<List<Integer>> res,TreeNode root,int level){
        if(root==null)return;
        if(level>res.size()){
            res.addFirst(new ArrayList<>());
        }
        res.get(res.size()-level).add(root.val);
        form(res,root.left,level+1);
        form(res,root.right,level+1);
    }
}