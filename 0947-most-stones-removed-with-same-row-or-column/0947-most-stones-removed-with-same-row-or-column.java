class Solution {
    public int removeStones(int[][] s) {
        int n = s.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for(int i = 0 ; i < n ; i ++){
            if(!vis[i]){
                res++;
                dfs(s,vis,i);
            }
        }
        return n - res;
    }
    private void dfs(int[][] s,boolean[] seen,int i){
        seen[i]=true;
        int[] curr = s[i];
        for(int j = 0 ; j < s.length ; j++){
            if(!seen[j]&&(curr[0]==s[j][0]||curr[1]==s[j][1]))
                dfs(s,seen,j);
        }
    }
}