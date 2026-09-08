class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        int count = 1000;
        int res = 0;
        while(count+1000<n){
            res+=1000;
            count+=1000;
        }
        res+=n-count+1;
        return res;
    }
}