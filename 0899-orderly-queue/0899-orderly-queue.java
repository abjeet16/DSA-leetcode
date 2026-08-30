class Solution {

    public String orderlyQueue(String s, int k) {

        if (k == 1) {

            int n = s.length();
            s = s + s;

            int best = 0;

            for (int i = 1; i < n; i++) {

                int j = 0;

                // Compare rotation starting at i
                // with rotation starting at best
                while (j < n && s.charAt(i + j) == s.charAt(best + j)) {
                    j++;
                }

                if (j < n && s.charAt(i + j) < s.charAt(best + j)) {
                    best = i;
                }
            }

            String ans = "";

            for (int i = best; i < best + n; i++) {
                ans += s.charAt(i);
            }

            return ans;
        }

        // k > 1
        char[] chars = s.toCharArray();

        // Manual sorting
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {

                if (chars[j] < chars[i]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        String ans = "";

        for (char c : chars) {
            ans += c;
        }

        return ans;
    }
}