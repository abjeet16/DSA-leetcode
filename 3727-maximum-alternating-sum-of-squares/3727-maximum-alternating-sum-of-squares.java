class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int[] nums1 = new int[len];
        int j = 1;
        for(int i = 0 ; i < len/2 ; i++){
            nums1[j] = nums[i]; 
            j+=2;
        }
        j=0;
        for(int i = len/2 ; i < len ; i++){
            nums1[j]=nums[i];
            j+=2;
        }
        //System.out.println(Arrays.toString(nums1));
        for(int i = 0 ; i < len; i+=2){
            int toa = (nums1[i]*nums1[i]);
            //System.out.println(toa);
            if(i<len-1)toa-=(nums1[i+1]*nums1[i+1]);
            //System.out.println(toa);
            ans+=toa;
        }
        return ans;
    }
}