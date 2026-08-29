class Solution {
    public boolean checkIfPangram(String s) {
        boolean[] seen = new boolean[26];
        int count = 0;
        for(char ch : s.toCharArray()){
            int idx = ch-'a';
            if(!seen[idx])count++;
            seen[idx]=true; 
            if(count==26)return true;
        }
        return false;
    }
}