class Solution {
    public int ladderLength(String bw, String ew, List<String> wl) {
        int n = wl.size();
        HashMap<String, List<Integer>> mp = new HashMap<>();
        for (int i = -1; i < n; i++) {
            String key = i == -1 ? bw : wl.get(i);
            List<Integer> match = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                boolean om = false;
                String curr = wl.get(j);
                int k = 0;
                while (k < curr.length()) {
                    if (curr.charAt(k) != key.charAt(k)) {
                        if (om)
                            break;
                        om = true;
                    }
                    k++;
                }
                if (k == curr.length() && om)
                    match.add(j);
            }
            mp.put(key, match);
        }
        boolean[] seen = new boolean[n];
        Queue<String> q = new LinkedList<>();
        for (int i : mp.get(bw)) {
            seen[i] = true;
            q.offer(wl.get(i));
        }
        int level = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String key = q.poll();
                if(key.equals(ew))return level;
                for (int j : mp.get(key)) {
                    if (!seen[j]) {
                        seen[j] = true;
                        q.offer(wl.get(j));
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
