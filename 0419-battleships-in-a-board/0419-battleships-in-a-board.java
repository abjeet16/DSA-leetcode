class Solution {
    int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
    public int countBattleships(char[][] b) {
        int res = 0;
        int m = b.length;
        int n = b[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j]&&b[i][j]=='X'){
                    res++;
                    dfs(b,seen,i,j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] b,boolean[][] seen,int i ,int j){
        if(b[i][j]!='X'||seen[i][j])return;

        seen[i][j]=true;
        for(int[] move : moves){
            int ni = i+move[0];
            int nj = j+move[1];
            if(ni>=0&&nj>=0&&ni<b.length&&nj<b[0].length){
                dfs(b,seen,ni,nj);
            }
        }
    }
}