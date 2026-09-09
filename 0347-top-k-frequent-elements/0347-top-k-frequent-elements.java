class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer>[] freq = new ArrayList[n+1];
        for(int i = 0 ; i < n+1;i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            int val = en.getKey();
            int f = en.getValue();
            freq[f].add(val);
        }

        int[] res = new int[k];
        int idx = 0;

        for(int i = n ; i >= 0 ; i--){
            for(int ele : freq[i]){
                res[idx++] = ele;
                if(idx==k)return res;
            }
        }
        return res;
    }
}