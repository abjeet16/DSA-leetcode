class Solution {
    int mod = Integer.MAX_VALUE;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo,-1);
        return find(arr,k,0,memo);
    }
    private int find(int[] arr , int k , int i,int[] memo){
        if(i==arr.length){
            return 0;
        }
        if(memo[i]!=-1)return memo[i];
        int res = 0;
        int max = 0;
        for(int j = i ; j < Math.min(i+k,arr.length); j++){
            max = Math.max(max,arr[j]);
            int lenSub = j-i+1;
            res = Math.max(res,lenSub*max+find(arr,k,j+1,memo));
        }
        return memo[i]=res%mod;
    }
}