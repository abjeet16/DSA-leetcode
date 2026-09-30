class Solution {
    int[][] moves = {{1,0},{0,1}};
    public boolean hasValidPath(char[][] grid) {
        HashMap<String,Boolean> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        Boolean[][][] memo = new Boolean[m][n][m+n];
        return find(grid,0,0,0,memo);
    }
    private boolean find(char[][] grid,int val,int i,int j,Boolean[][][] memo){
        val += grid[i][j]=='('?1:-1;
        if(val<0)return false;
        int m = grid.length;
        int n = grid[0].length;
        
        if(i==m-1&&j==n-1)return val==0;
        
        if(memo[i][j][val]!=null)return memo[i][j][val];

        boolean res = false;

        for(int[] move : moves){
            int ni = i+move[0];
            int nj = j+move[1];

            if(ni>=0&&nj>=0&&ni<m&&nj<n&&find(grid,val,ni,nj,memo)){
                res = true;
                break;
            }
        }
        return memo[i][j][val]=res;
    }
}