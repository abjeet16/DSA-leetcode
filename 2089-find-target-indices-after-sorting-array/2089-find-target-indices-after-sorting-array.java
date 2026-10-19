class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThen = 0;
        int tarC = 0;
        for(int i : nums){
            if(i<target){
                lessThen++;
            }else if(i==target){
                tarC++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tarC; i++) {
            res.add(lessThen+i);
        }

        return res;
    }
}