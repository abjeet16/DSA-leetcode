class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();
        find(res,curr,0,n+n,0);
        return res;
    }
    private void find(List<String> res, StringBuilder curr,int i ,int n ,int val){
        if(val<0)return;
        if(i==n){
            //System.out.println(curr);
            if(val==0){
                res.add(curr.toString());
            }
            return;
        }

        curr.append('(');
        find(res,curr,i+1,n,val+1);
        curr.deleteCharAt(curr.length()-1);
        curr.append(')');
        find(res,curr,i+1,n,val-1);
        curr.deleteCharAt(curr.length()-1);
    }
}