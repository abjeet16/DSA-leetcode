class Solution {
    int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
    public int findMaxFish(int[][] g) {
        int res = 0;
        int m = g.length;
        int n = g[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j])res = Math.max(res,dfs(i,j,g,seen));
            }
        }
        return res;
    }
    private int dfs(int i , int j , int[][] g,boolean[][] seen){
        if(g[i][j]==0||seen[i][j])return 0;

        seen[i][j] = true;
        int res = g[i][j];
        for(int[] move : moves){
            int ni = i+move[0];
            int nj = j+move[1];
            
            if(ni>=0&&nj>=0&&ni<g.length&&nj<g[0].length)res+=dfs(ni,nj,g,seen);
        }
        return res;
    }
}