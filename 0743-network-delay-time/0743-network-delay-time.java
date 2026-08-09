class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] mat = new int[n][n];
        form(mat, times);
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.offer(new int[] { k - 1, 0 });
        int res = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            for (int i = 0; i < n; i++) {
                if (mat[node][i] != -1 && dis[i] > cost + mat[node][i]) {
                    dis[i] = cost + mat[node][i];
                    q.offer(new int[] { i, dis[i] });
                }
            }
        }
        for (int i : dis)
            if (i == Integer.MAX_VALUE)
                return -1;
            else
                res = Math.max(res, i);
        return res;
    }

    private void form(int[][] mat, int[][] times) {
        for (int[] i : mat)
            Arrays.fill(i, -1);
        for (int[] time : times) {
            int i = time[0] - 1;
            int j = time[1] - 1;
            mat[i][j] = time[2];
        }
    }
}