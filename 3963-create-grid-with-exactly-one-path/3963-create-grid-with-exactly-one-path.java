class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        for(int i = 0 ; i < m-1 ; i++){
            StringBuilder row = new StringBuilder();
            row.append('.');
            for(int j = 0 ; j < n-1 ; j++){
                row.append('#');
            }
            res[i] = row.toString();
        }
        StringBuilder row = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            row.append('.');
        }
        res[m-1]=row.toString();

        return res;
    }
}