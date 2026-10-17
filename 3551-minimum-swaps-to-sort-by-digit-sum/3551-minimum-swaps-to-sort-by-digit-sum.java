class Solution {
    public int minSwaps(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        Integer[] nums1 = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],i);
            nums1[i] = nums[i];
        }

        Arrays.sort(nums1,(a,b)->{ 
            int c1 = getCount(a);
            int c2 = getCount(b);
            if(c1==c2){
                return Integer.compare(a,b);
            }
            return Integer.compare(c1,c2);
        });

        //System.out.println(Arrays.toString(nums1));

        int res = 0;

        for(int i = 0 ; i < n ;i++){
            if(nums1[i]!=nums[i]){
                int idx = map.get(nums1[i]);
                map.put(nums[i],idx);
                nums[idx]=nums[i];
                res++;
            }
        }
        return res;
    }

    private int getCount(int num){
        int res = 0;
        while(num!=0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}