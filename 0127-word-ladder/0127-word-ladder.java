class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(startWord, 1));

        Set<String> st = new HashSet<>(wordList);
        st.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().getKey();
            int steps = q.peek().getValue();
            q.poll();

            // If target word is found
            if (word.equals(targetWord)) return steps;

            // Try changing every character
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.add(new Pair<>(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }

}