class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if(n<=10)return res;

        HashMap<String,Boolean> map = new HashMap<>();
        StringBuilder curr = new StringBuilder();
        for(int i = 0 ; i < 10  ; i++){
            curr.append(s.charAt(i));
        }
        map.put(curr.toString(),false);
        for(int i = 10 ; i < n ; i++){
            curr.deleteCharAt(0);
            curr.append(s.charAt(i));

            String currS = curr.toString();
            if(map.containsKey(currS)){
                if(!map.get(currS)){
                    map.put(currS,true);
                    res.add(currS);
                }
            }else{
                map.put(currS,false);
            }
        }
        return res;
    }
}