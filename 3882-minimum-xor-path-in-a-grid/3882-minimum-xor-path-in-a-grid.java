class Solution {
    int res = Integer.MAX_VALUE;
    int[][] moves = {{0,1},{1,0}};
    public int minCost(int[][] grid) {
        Set<String> st = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] memo = new boolean[m][n][1024];
        
        /*for(int[][] mat : memo)
            for(int[] row : mat)
                Arrays.fill(row,-1);*/
        
        dfs(0,0,0,grid,memo);
        return res;
    }
    private void dfs(int i,int j ,int xor , int[][] grid,boolean[][][] memo){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n)return;

        xor^=grid[i][j];
        if(memo[i][j][xor])return;
        memo[i][j][xor] = true;

        if(i==m-1&&j==n-1){
            res = Math.min(res,xor);
            return;
        }

        for(int[] move : moves){
            dfs(i+move[0],j+move[1],xor,grid,memo);
        }
    }
}