class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for(int i = 0 ; i < n ; i++){
            int lar = nums[i];
            int sml = nums[i];
            for(int j = i ; j < n ; j++){
                lar = Math.max(lar,nums[j]);
                sml = Math.min(sml,nums[j]);
                res += lar-sml;
            }
        }
        return res;
    }
}