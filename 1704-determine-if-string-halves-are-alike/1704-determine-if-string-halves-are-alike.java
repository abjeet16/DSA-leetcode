class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length()/2 ; i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='i'||ch=='o'||ch=='e'||ch=='u'||ch=='A'||ch=='I'||ch=='O'||ch=='E'||ch=='U'){
                count++;
            }
        }
        for(int i = s.length()/2 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='i'||ch=='o'||ch=='e'||ch=='u'||ch=='A'||ch=='I'||ch=='O'||ch=='E'||ch=='U'){
                count--;
            }
        }
        return count==0;
    }
}