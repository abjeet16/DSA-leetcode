class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] in = new boolean[n];
        for(List<Integer> ed : edges){
            in[ed.get(1)] = true;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!in[i])res.add(i);
        }
        return res;
    }
}