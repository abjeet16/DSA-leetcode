class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum)return "";
        int nines = sum/9;
        int rem = sum%9;

        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < nines ; i++){
            res.append("9");
        }

        if(rem>0)res.append(rem);

        int zeros = num - res.length();
        
        for (int i = 0; i < zeros; i++) 
        {
            res.append('0');
        }

        return res.toString();
    }
}