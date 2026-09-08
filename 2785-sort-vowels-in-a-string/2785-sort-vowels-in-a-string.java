class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> l = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                l.add(ch);
        }
        Collections.sort(l);
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(char ch : s.toCharArray()){
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                res.append(l.get(i));
                i++;
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}