class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        boolean[] taken = new boolean[26];

        for(int i = 0 ; i < s.length() ; i++){
            //System.out.println(st);
            char ch = s.charAt(i);
            if(taken[ch-'a'])continue;
            while(!st.isEmpty()&&st.peek()>ch&&check(s,i,st.peek())){
                taken[st.pop()-'a']=false;;
            }
            st.push(ch);
            taken[ch-'a']=true;

        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())res.append(st.pop());
        return res.reverse().toString();
    }
    private boolean check(String s, int i , char ch){
        while(i<s.length()){
            if(s.charAt(i)==ch)return true;
            i++;
        }
        return false;
    }
}