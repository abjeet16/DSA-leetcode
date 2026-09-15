class Solution {
    int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] g) {
        int res = 0;
        int m = g.length;
        int n = g[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j]&&g[i][j]==1){
                    //System.out.println(i+" "+j+"------------");
                    res = Math.max(res,find(g,i,j,seen));
                }
                seen[i][j] = true;
            }
        }
        return res;
    }
    private int find(int[][] g,int i ,int j ,boolean[][] seen){
        //System.out.println(i+" "+j);
        if(seen[i][j]||g[i][j]==0)return 0;
        seen[i][j] = true;
        int res = 1;
        for(int[] move : moves){
            int ni = move[0]+i;
            int nj = move[1]+j;
            if(ni>=0&&nj>=0&&ni<g.length&&nj<g[0].length&&!seen[ni][nj])
                res += find(g,ni,nj,seen);
        }
        return res;
    }
}