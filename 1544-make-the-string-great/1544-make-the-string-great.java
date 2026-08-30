class Solution {
    public String makeGood(String s) {
        int c = -1;
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            //if(c!=-1)System.out.println(c+" "+(char)(res.charAt(c)-32));
            //System.out.println((char)(s.charAt(i)+32));
            if(c!=-1&&(s.charAt(i)==res.charAt(c)-32||res.charAt(c)+32==s.charAt(i))){
                res.deleteCharAt(c);
                c--;
            }else{
                res.append(s.charAt(i));
                c++;
            }
        }
        return res.toString();
    }
}