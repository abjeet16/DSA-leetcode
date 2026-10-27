class Solution {
    int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}}; 
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int res = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j]&&grid[i][j]!=0){
                    long val = dfs(seen,i,j,grid);
                    if(val%k==0)res++;
                }
            }
        }
        return res;
    }
    private long dfs(boolean[][] seen,int i ,int j , int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||seen[i][j]||grid[i][j]==0)return 0;
        seen[i][j]=true;
        long res = grid[i][j];

        for(int[] move : moves){
            int ni = i+move[0];
            int nj = j+move[1];
            res+=dfs(seen,ni,nj,grid);
        }
        return res;
    }
}