class Solution {
    public String getHint(String s, String g) {
        int[] freq = new int[10];
        int n = s.length();
        int A = 0;
        int B = 0;

        for(int i = 0 ; i < n ; i++){
            int si = s.charAt(i)-'0';
            int gi = g.charAt(i)-'0';
            if(si==gi){
                A++;
            }else{
                freq[si]++;
                if(freq[si]<=0)B++;
                if(freq[gi]>0)B++;
                freq[gi]--;
            }
        }
        return A+"A"+B+"B";
    }
}