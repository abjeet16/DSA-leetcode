class Solution {
    int[][] moves = { { 0, 1 }, { 1, 0 } };
    int mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] seen = new Integer[m+1][n+1][3];
        return find(0, 0, grid, -1,seen);
    }

    private int find(int i, int j, int[][] grid, int prev,Integer[][][] seen) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if(seen[i][j][prev+1]!=null)return seen[i][j][prev+1];
        int res = 0;
        if (grid[i][j] == 1) {
            if(prev==0){
                res+=find(i+1,j,grid,1,seen)%mod;
            }else{
                res+=find(i,j+1,grid,0,seen)%mod;
            }
        } else {
            for (int k = 0; k < 2; k++) {
                res += find(i + moves[k][0], j + moves[k][1], grid, k,seen)%mod;
            }
        }
        return seen[i][j][prev+1]=res%mod;
    }
}