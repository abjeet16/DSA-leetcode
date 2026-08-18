class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        find(1,n,new ArrayList<Integer>(),k,res);
        return res;
    }
    private void find(int i,int n , ArrayList<Integer> curr,int k,List<List<Integer>> res){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>n)return;
        curr.add(i);
        find(i+1,n,curr,k,res);
        curr.remove(curr.size()-1);
        find(i+1,n,curr,k,res);
    }
}