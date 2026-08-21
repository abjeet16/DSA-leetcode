class Solution {
    public String intToRoman(int num) {
        String[] chars = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] val = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder res = new StringBuilder();
        for(int i = 12 ; i >=0 ; i--){
            res.repeat(chars[i],num/val[i]);
            num%=val[i];
        }
        return res.toString();
    }
}