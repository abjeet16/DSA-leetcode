class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() <= 10) return res;

        HashSet<String> seen = new HashSet<>();
        HashSet<String> added = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String curr = s.substring(i, i + 10);

            if (seen.contains(curr)) {
                if (added.add(curr)) {
                    res.add(curr);
                }
            } else {
                seen.add(curr);
            }
        }

        return res;
    }
}