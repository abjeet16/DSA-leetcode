class Solution {
    public int[][] insert(int[][] i1, int[] i2) {
        int i = 0;
        int n = i1.length;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < n) {
            if (i1[i][1] < i2[0]) {
                res.add(i1[i]);
            } else if (i2[1] < i1[i][0]) {
                break;
            } else {
                i2[0] = Math.min(i1[i][0], i2[0]);
                i2[1] = Math.max(i1[i][1], i2[1]);
            }
            i++;
        }
        res.add(i2);
        while (i < n) {
            res.add(i1[i]);
            i++;
        }
        int[][] ans = new int[res.size()][2];
        form(ans, res);
        return ans;
    }

    private void form(int[][] ans, ArrayList<int[]> list) {
        int c = 0;
        for (int[] i : list) {
            ans[c][0] = i[0];
            ans[c][1] = i[1];
            c++;
        }
    }
}