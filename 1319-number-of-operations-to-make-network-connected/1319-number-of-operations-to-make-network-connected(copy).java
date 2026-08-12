class Solution {
    public int makeConnected(int n, int[][] c) {
        if(c.length<n-1)return -1;
        boolean[] vis = new boolean[n];
        List<Integer>[] mat = new ArrayList[n];
        form(mat,n,c);
        int noComp = 0;
        for(int i = 0 ; i < n ; i ++){
            if(!vis[i]){
                noComp++;
                dfs(i,mat,vis);
            }
        }
        return noComp-1;
    }
    private void form(List<Integer>[] mat,int n, int[][] c){
        for(int i = 0 ; i < n ; i++){
            mat[i]=new ArrayList<>();
        }
        for(int[] i : c){
            mat[i[0]].add(i[1]);
            mat[i[1]].add(i[0]);
        }
    }
    private void dfs(int i , List<Integer>[] mat , boolean[] vis){
        for(int j = 0 ; j < mat[i].size() ; j++){
            if(!vis[mat[i].get(j)]){
                vis[mat[i].get(j)] = true;
                dfs(mat[i].get(j),mat,vis);
            }
        }
    }
}
