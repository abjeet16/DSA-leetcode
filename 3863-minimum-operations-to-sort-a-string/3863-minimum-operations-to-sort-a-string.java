class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if(check(chars))return 0;

        if(n<=2)return -1;

        int maxi = 0;
        int mini = 0;

        for(int i = 0 ; i < n ; i++){
            if(chars[i]>=chars[maxi])maxi=i;
            if(chars[i]<chars[mini])mini=i;
        }
        if(mini==0||maxi==n-1)return 1;

        int maxMid = 1;
        int minMid = 1;

        for(int i = 1 ; i < n-1 ; i++){
            if(chars[i]>=chars[maxMid])maxMid=i;
            if(chars[i]<chars[minMid])minMid=i;
        }

        if(chars[0]>chars[maxMid]&&chars[n-1]<chars[minMid])return 3;
        
        return 2;
    }
    private boolean check(char[] chars){
        char prev = 'a';
        for(char ch : chars){
            if(prev>ch)return false;
            prev = ch;
            //System.out.println(ch);
        }
        return true;
    }
}