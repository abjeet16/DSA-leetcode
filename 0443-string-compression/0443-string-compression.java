class Solution {
    public int compress(char[] chars) {
        int res = 0;
        int i = 0;
        int n = chars.length;
        while(i<n){
            char ch = chars[i];
            chars[res]=ch;
            res++;
            i++;
            int count = 1;
            while(i<n&&chars[i]==ch){
                count++;
                i++;
            }
            if(count>1){
                //System.out.println(count);
                String c = ""+count;
                for(int j = 0 ; j < c.length() ; j++){
                    chars[res]=c.charAt(j);
                    res++;
                }
            }
        }
        //System.out.println(Arrays.toString(chars));
        return res;
    }
}