class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        //print(g);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr =new ArrayList<>();
        curr.add(0);
        find(g,0,curr,res);
        return res;
    }
    private void find(int[][] g,int i,ArrayList<Integer> curr,List<List<Integer>> res){
        if(i==g.length-1){
            res.add(new ArrayList<>(curr));
            return;
        }
        //System.out.println(curr);
        for(int j = 0 ; j < g[i].length ; j++){
            curr.add(g[i][j]);
            find(g,g[i][j],curr,res);
            curr.remove(curr.size()-1);
        }
    }
    private void print(int[][] g){
        for(int[] i : g)
            System.out.println(Arrays.toString(i));
    }
}