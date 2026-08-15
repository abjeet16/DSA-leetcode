class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        find(nums,0,new ArrayList<Integer>(),new boolean[nums.length],set);
        return new ArrayList<List<Integer>>(set);
    }
    private void find(int[] nums,int i,ArrayList<Integer> curr,boolean[] seen,HashSet<List<Integer>> set){
        if(curr.size()==nums.length){
            set.add(new ArrayList(curr));
            return;
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(!seen[j]){
                seen[j]=true;
                curr.add(nums[j]);
                find(nums,i+1,curr,seen,set);
                curr.removeLast();
                seen[j]=false;
            }
        }
    }
}