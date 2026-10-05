class Solution {
    public int minAddToMakeValid(String s) {
        int val = 0;
        int res = 0;
        for(char ch : s.toCharArray()){
            if(val<0){
                res++;
                val=0;
            }
            if(ch=='(')val++;
            else val--;
        }
        return res+Math.abs(val);
    }
}