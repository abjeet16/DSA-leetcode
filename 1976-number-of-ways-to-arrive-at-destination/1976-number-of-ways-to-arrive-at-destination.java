class Solution {
    int mod = 1000000007;

    public int countPaths(int n, int[][] roads) {
        int resd = Integer.MAX_VALUE;
        int res = 0;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[][] mat = new int[n][n];
        form(mat, roads);

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.offer(new long[] { 0, 0 });

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            int node = (int)curr[0];
            long cost = curr[1];
            if (cost > dist[node])
                continue;

            for (int i = 0; i < n; i++) {
                if (mat[node][i] != -1 && dist[i] >= cost + mat[node][i]) {
                    long newCost = cost + mat[node][i];
                    if (newCost < dist[i]) {
                        dist[i] = newCost;
                        ways[i] = ways[node];
                        q.offer(new long[] { i,newCost });
                    } else if (newCost == dist[i]) {
                        ways[i] = (ways[i] + ways[node]) % mod;
                    }
                }
            }
        }
        return ways[n-1];
    }

    private void form(int[][] mat, int[][] roads) {
        for (int[] i : mat) {
            Arrays.fill(i, -1);
        }
        for (int[] road : roads) {
            int i = road[0];
            int j = road[1];
            int cost = road[2];

            mat[i][j] = cost;
            mat[j][i] = cost;
        }
    }
}