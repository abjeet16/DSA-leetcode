class Solution {
    public int makeConnected(int n, int[][] c) {
        if(n-1>c.length)return -1;

        int[] par = new int[n];
        for(int i = 0 ; i < n ; i++)par[i]=i;

        int[] rank = new int[n];

        int noComp = n;

        for(int[] i : c){
            int pu = find(i[0],par);
            int pv = find(i[1],par);
            if(pu!=pv){
                noComp--;
                uni(pu,pv,par,rank);
            }
        }
        return noComp-1;
    }
    private int find(int i , int[] par){
        if(i==par[i])return i;
        return par[i]=find(par[i],par);
    }
    private void uni(int pu,int pv,int[] par,int[] rank){
        if(rank[pu]==rank[pv]){
            par[pv]=pu;
            rank[pu]++;
        }else if(rank[pu]>rank[pv]){
            par[pv]=pu;
        }else{
            par[pu]=pv;
        }
    }
}