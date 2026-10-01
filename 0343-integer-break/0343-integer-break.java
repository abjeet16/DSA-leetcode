class Solution {
    public int integerBreak(int n) {
        HashMap<String,Integer> memo = new HashMap<>();
        return find(n,0,1,memo);
    }
    private int find(int n , int sum , int pro,HashMap<String,Integer> memo){
        if(sum==n)return pro;
        if(sum>n)return 0;

        String key = sum+" "+pro;
        if(memo.containsKey(key))return memo.get(key);

        int res = 0;
        for(int i = 1 ; i < n ; i++){
            res = Math.max(res,find(n,sum+i,pro*i,memo));
        }
        memo.put(key,res);
        return memo.get(key);
    }
}