class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n+m!=s3.length())return false;
        Boolean[][] memo = new Boolean[n][m];
        return check(s1,s2,s3,0,0,0,memo);
    }
    private boolean check(String s1,String s2,String s3,int i,int j,int k,Boolean[][] memo){
        //System.out.println(i+" "+j+" "+k);
        if(k==s3.length())return true;
        if(i==s1.length()){
            //System.out.println(s3.substring(k)+" "+s2.substring(j));
            return s3.substring(k).equals(s2.substring(j));
        }
        if(j==s2.length()){
            //System.out.println(s3.substring(k)+" "+s2.substring(j));
            return s3.substring(k).equals(s1.substring(i));
        }
        if(memo[i][j]!=null)return memo[i][j];
        char req = s3.charAt(k);
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        boolean res = false;
        if(req==ch1&&check(s1,s2,s3,i+1,j,k+1,memo))res=true;
        if(req==ch2&&check(s1,s2,s3,i,j+1,k+1,memo))res=true;
        return memo[i][j]=res;
    }
}