class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch :  s.toCharArray()){
            if(ch==')'){
                StringBuilder str = new StringBuilder();
                while(!st.isEmpty()&&st.peek()!='('){
                    str.append(st.pop());
                }
                st.pop();
                for(int i = 0 ; i < str.length() ; i++)st.push(str.charAt(i));
            }else{
                st.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        //System.out.println(st);
        while(!st.isEmpty())res.append(st.pop());
        return res.reverse().toString();
    }
}