class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int vo = 0;
            int co = 0;
            for (int j = i; j < s.length(); j++) {
                if (isVol(s.charAt(j))) {
                    vo++;
                } else {
                    co++;
                }
                if (vo > 0 && co > 0 && co == vo && (co * vo) % k == 0)
                    res++;
            }
        }
        return res;
    }

    private int find(String s, int i, int k) {
        if (i == s.length())
            return 0;
        int res = 0;
        int vo = 0;
        int co = 0;
        for (int j = i; j < s.length(); j++) {
            if (isVol(s.charAt(j))) {
                vo++;
            } else {
                co++;
            }
            if (vo > 0 && co > 0 && co == vo && (co * vo) % k == 0)
                res++;
        }
        res += find(s, i + 1, k);
        return res;
    }

    private boolean isVol(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

}