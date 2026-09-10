class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] window = new int[26];

        int n = s1.length();
        for (char ch : s1.toCharArray())
            freq[ch - 'a']++;
        int i = 0;
        int j = 0;
        while(i < s2.length()){
            window[s2.charAt(i)-'a']++;
            if(i-j+1>n){
                window[s2.charAt(j)-'a']--;
                j++;
            }
            if(check(freq,window))return true;
            i++;
        }
        return false;
    }
    private boolean check(int[] arr1,int[] arr2){
        for(int i = 0 ; i < 26 ; i++)if(arr1[i]!=arr2[i])return false;
        return true;
    }

    private void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private void copy(int[] arr, int[] arr1) {
        for (int i = 0; i < 26; i++)
            arr1[i] = arr[i];
    }
}