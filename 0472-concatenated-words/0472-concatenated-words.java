class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            HashMap<String,Boolean> map = new HashMap<>();
            if (find(set, words, 0, new StringBuilder(), word,0,map))
                res.add(word);
        }
        return res;
    }

    private boolean find(Set<String> set, String[] words, int i, StringBuilder prev, String word,int count,HashMap<String,Boolean> map ) {
        if (i == word.length()) {
            return prev.length() == 0 && count > 1;
        }
        String key = i+"#"+prev;
        if(map.containsKey(key))return map.get(key);

        boolean res = false;
        prev.append(word.charAt(i));
        if (set.contains(prev.toString())) {
            if (find(set, words, i + 1, new StringBuilder(), word,count+1,map))
                res = true;
        }
        if (find(set, words, i + 1, prev, word,count,map))
            res = true;
        prev.deleteCharAt(prev.length() - 1);
        map.put(key,res);
        return res;
    }
}