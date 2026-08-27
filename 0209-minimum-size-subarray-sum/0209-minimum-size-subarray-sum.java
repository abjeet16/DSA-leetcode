class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0 , j = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int currSum = 0;

        while(i<n){
            currSum+=nums[i];

            while(currSum>=target){
                res = Math.min(res,i+1-j);
                currSum-=nums[j];
                j++;
            }
            i++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}