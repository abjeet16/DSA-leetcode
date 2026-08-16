class Solution {
    public int divide(int up, int down) {
        if(up==Integer.MIN_VALUE&&down==-1)return Integer.MAX_VALUE;

        long copyu = Math.abs((long)up);
        long copyd = Math.abs((long)down);

        int res = 0;

        while(copyu>=copyd){

            long twomul = 1;
            long val = copyd;

            while((val<<1)<=copyu){
                val<<=1;
                twomul<<=1;
            }
            res+=twomul;
            copyu-=val;
        }
        if((up<0&&down>0)||(down<0&&up>0))return -res;
        return res;
    }
}