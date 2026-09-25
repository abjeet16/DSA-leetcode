class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[rooms.size()];
        int rv = 1;
        vis[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : rooms.get(curr)){
                if(!vis[i]){
                    vis[i]=true;
                    rv++;
                    q.offer(i);
                }
            }
        }
        return rv==rooms.size();
    }
}