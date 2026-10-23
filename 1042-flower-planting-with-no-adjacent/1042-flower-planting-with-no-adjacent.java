class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color = new int[n];
        boolean[] vis = new boolean[n];
        List<Integer>[] mat = new ArrayList[n];
        form(paths, mat, n);

        Queue<Integer> q = new LinkedList<>();
        for (int  j = 0; j < n; j++) {
            if(!vis[j]){
                q.offer(j);
                vis[j]=true;
                while (!q.isEmpty()) {
                int curr = q.poll();
                List<Integer> nabs = mat[curr];
                boolean[] done = new boolean[n+1];
                for (int nab : nabs) {
                    done[color[nab]] = true;
                }
                for (int i = 1; i <= n; i++) {
                    if (!done[i]) {
                        //System.out.println(i);
                        color[curr] = i;
                        break;
                    }
                }
                for (int i : mat[curr]) {
                    if (!vis[i]) {
                        q.offer(i);
                        vis[i] = true;
                    }
                }
            }
            }
        }
        return color;
    }

    private void form(int[][] paths, List<Integer>[] mat, int n) {
        for (int i = 0; i < n; i++) {
            mat[i] = new ArrayList<Integer>();
        }
        for (int[] path : paths) {
            int i = path[0] - 1;
            int j = path[1] - 1;
            //System.out.println(i + " " + j);

            mat[i].add(j);
            mat[j].add(i);
        }
    }
}