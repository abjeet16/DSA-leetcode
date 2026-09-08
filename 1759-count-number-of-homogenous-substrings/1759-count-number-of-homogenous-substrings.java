class Solution {
    int mod = 1000000007;
    public int countHomogenous(String s) {
        int res = 0;
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        for(int i = 0;i < s.length() ; i++)res=(res+find(s,i,'0',memo))%mod;
        return res;
    }
    private int find(String s, int i,char prev,int[] memo){
        if(i==s.length())return 0;
        if(memo[i]!=-1)return memo[i];
        int res = 0;
        if(prev=='0'||s.charAt(i)==prev){
            res=(1+find(s,i+1,s.charAt(i),memo))%mod;
        }
        if(prev==s.charAt(i)||prev=='0')memo[i]=res;
        return res;
    }
}