class Solution {
    public double maxProbability(int n, int[][] e, double[] sp, int start, int end) {
        //double[][] mat = new double[n][n];
        List<double[]>[] mat = new ArrayList[n];
        form(mat, e, sp, n);
        //print(mat);
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        q.offer(new double[] { start, 1.0 });
        double[] bp = new double[n];
        Arrays.fill(bp, 0.0);
        bp[start] = 1.0;
        while (!q.isEmpty()) {
            double[] curr = q.poll();
            int node = (int) curr[0];
            double prob = curr[1];
            if (node == end)
                break;
            if (prob < bp[node] || prob == 0)
                continue;
            for (double[] edge : mat[node]) {
                double newProb = prob * edge[1];
                int i = (int)edge[0];
                if (newProb > bp[i]) {
                    bp[i] = newProb;
                    q.offer(new double[] { i, newProb });
                }
            }
        }
        return bp[end];
    }

    /*private void form(int[][] mat , int[][] e ,double[] sp){
        for(double[] i : mat )Arrays.fill(i,-1);
        int c = 0;
        for(int[] i : e){
            mat[i[0]][i[1]]=sp[c];
            mat[i[1]][i[0]]=sp[c];
            c++;
        }
    }*/
    private void form(List<double[]>[] mat, int[][] e, double[] sp, int n) {
        for (int i = 0; i < n; i++) {
            mat[i]=new ArrayList<>();
        }
        int c = 0;
        for (int[] i : e) {
            mat[i[0]].add(new double[] { i[1], sp[c] });
            mat[i[1]].add(new double[] { i[0], sp[c] });
            c++;
        }
    }

    private void print(double[][] mat) {
        for (double[] i : mat)
            System.out.println(Arrays.toString(i));
    }
}