class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i = 0 ;
        int n = path.length();
        while(i<n){
            char ch = path.charAt(i);
            if(ch=='/'){
                if(st.isEmpty()||!st.peek().equals("/"))st.push(ch+"");
                i++;
            }else if(ch=='.'){
                String str = "";
                while(i<n&&path.charAt(i)!='/'){
                    str+=path.charAt(i);
                    i++;
                }
                int len = str.length();
                if(len==1)continue;
                else if(len==2&&str.charAt(1)=='.'){
                    if(st.size()>1){
                        st.pop();
                        st.pop();
                    }
                }
                else st.push(str);
            }else{
                String str = "";
                while(i<n&&path.charAt(i)!='/'){
                    str+=path.charAt(i);
                    i++;
                }
                st.push(str);
            }
        }
        while(!st.isEmpty()&&st.peek().equals("/")){
            st.pop();
        }
        String[] strs = new String[st.size()];
        i = st.size()-1;
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            strs[i] = st.pop();
            i--;
            //res.append(st.pop());
        }
        for(String str : strs)res.append(str);
        if(res.length()==0)return "/";
        return res.toString();
    }
}