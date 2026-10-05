class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            //System.out.println(st);
            if (ch == '(') {
                st.push(ch + "");
            } else {
                int val = 0;
                while (!st.peek().equals("(")) {
                    int num = getNum(st.pop());
                    val += num;
                }
                st.pop();
                if (val == 0)
                    st.push(1 + "");
                else
                    st.push(val * 2 + "");
            }
        }
        //System.out.println(st);
        int val = 0;
        while (!st.isEmpty()) {
            int num = getNum(st.pop());
            val += num;
        }
        return val;
    }

    private int getNum(String num) {
        int res = 0;
        for (char ch : num.toCharArray()) {
            res = res * 10 + (ch - '0');
        }
        return res;
    }
}