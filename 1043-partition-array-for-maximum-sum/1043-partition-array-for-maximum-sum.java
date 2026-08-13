class Solution {
    int mod = Integer.MAX_VALUE;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] memo = new int[arr.length][k+1];
        for(int[] i : memo)Arrays.fill(i,-1);
        return find(arr,k,0,0,Integer.MIN_VALUE,memo);
    }
    private int find(int[] arr , int k ,int count, int i,int max,int[][] memo){
        if(i==arr.length){
            return max*count;
        }
        int res = 0;
        max = Math.max(max,arr[i]);
        count++;
        if(memo[i][count]!=-1)return memo[i][count];
        if(count<k){
            res = Math.max(res,find(arr,k,count,i+1,max,memo));
        }
        res = Math.max(res,count*max+find(arr,k,0,i+1,Integer.MIN_VALUE,memo));
        return memo[i][count]=res%mod;
    }
}