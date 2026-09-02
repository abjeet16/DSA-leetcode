class Solution {
    public boolean buddyStrings(String s, String g) {
        if(s.length()!=g.length())return false;
        int[] freq = new int[26];
        int i = -1;
        int j = -1;
        boolean twoCh = false;
        for(int k = 0 ; k < s.length() ; k++){
            freq[s.charAt(k)-'a']++;
            if(freq[s.charAt(k)-'a']==2)twoCh = true;
            if(s.charAt(k)!=g.charAt(k)){
                if(i==-1)i=k;
                else if(j==-1)j=k;
                else return false;
            }
        }
        if(i!=-1&&j!=-1){
            if(s.charAt(i)==g.charAt(j)&&g.charAt(i)==s.charAt(j))return true;
        }
        return s.equals(g)&&twoCh;
    }
}