class Solution {
    public long countCommas(long n) {
        if(n<1000)return 0;
        long start = 1000;
        long res = 0;
        int comma = 1;
        while(start<=n){
            long end = start*1000-1;
            res = res + (Math.min(n,end)-start+1)*comma;

            start*=1000;
            comma++;
        }
        return res;
    }
}