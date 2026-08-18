class Solution {

    public int minDistance(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();

        int memo[][] = new int[m][n];
        for(int[] i : memo)Arrays.fill(i,-1);

        return find(w1, w2, 0, 0,memo);
    }

    private int find(String w1, String w2, int i, int j,int[][] memo) {
        if (i == w1.length() && j == w2.length())
            return 0;

        if (i == w1.length())
            return w2.length() - j;

        if (j == w2.length())
            return w1.length() - i;

        if(memo[i][j]!=-1)return memo[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return memo[i][j] = find(w1, w2, i + 1, j + 1,memo);
        }
        int del = find(w1,w2,i+1,j,memo);
        int ins = find(w1,w2,i,j+1,memo);
        int rep = find(w1,w2,i+1,j+1,memo);

        return memo[i][j]=1+ Math.min(del,Math.min(ins,rep));
    }
}