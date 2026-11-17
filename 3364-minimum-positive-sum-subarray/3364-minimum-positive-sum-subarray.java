class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;
        int n = nums.size();

        for(int i = 0; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum+=nums.get(j);
                int size = j-i+1;
                //System.out.println(size);
                if(sum>0&&sum<res&&size>=l&&size<=r){
                    res = sum;
                }
            }
        }

        return res==Integer.MAX_VALUE?-1:res;
    }
}