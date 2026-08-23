class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        curr.append(s.charAt(0));
        find(res,new StringBuilder(),1,0,curr,s);
        return res;
    }
    private void find(List<String> res,StringBuilder ans,int i,int dots,StringBuilder curr,String s){
        //System.out.println(ans);
        if(dots>3||!check(curr))return;

        if(i==s.length()){
            if(dots<3)return;
            int len = ans.length();
            ans.append(curr);
            res.add(ans.toString());
            ans.setLength(len);
            return;
        }

        curr.append(s.charAt(i));
        find(res,ans,i+1,dots,curr,s);
        curr.deleteCharAt(curr.length()-1);

        int len = ans.length();
        ans.append(curr).append('.');
        StringBuilder ncurr = new StringBuilder();
        ncurr.append(s.charAt(i));
        find(res,ans,i+1,dots+1,ncurr,s);
        ans.setLength(len);
    }

    private boolean check(StringBuilder curr){
        int n = curr.length();
        if(n==0||n>3||(curr.charAt(0)=='0'&&n>1))return false;
        int num = 0;
        for(int i = 0;i<n;i++){
            num = num*10+(curr.charAt(i)-'0');
        }
        //System.out.println(num);
        return num<=255;
    }
}