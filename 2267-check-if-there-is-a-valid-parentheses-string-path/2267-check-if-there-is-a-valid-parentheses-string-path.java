class Solution {
    int[][] moves = {{1,0},{0,1}};
    public boolean hasValidPath(char[][] grid) {
        HashMap<String,Boolean> map = new HashMap<>();
        return find(grid,0,0,0,map);
    }
    private boolean find(char[][] grid,int val,int i,int j,HashMap<String,Boolean> map){
        val += grid[i][j]=='('?1:-1;
        if(val<0)return false;
        int m = grid.length;
        int n = grid[0].length;
        
        if(i==m-1&&j==n-1)return val==0;
        String key = i+" "+j+" "+val;
        if(map.containsKey(key))return map.get(key);

        boolean res = false;

        for(int[] move : moves){
            int ni = i+move[0];
            int nj = j+move[1];

            if(ni>=0&&nj>=0&&ni<m&&nj<n&&find(grid,val,ni,nj,map)){
                res = true;
                break;
            }
        }
        map.put(key,res);
        return res;
    }
}