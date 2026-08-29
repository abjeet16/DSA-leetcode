class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        int i = 0;
        int j = 0;
        int ci = 0;
        int cj = 0;
        while(i<w1.length&&j<w2.length){
            while(ci<w1[i].length()&&cj<w2[j].length()){
                if(w1[i].charAt(ci)!=w2[j].charAt(cj))return false;
                ci++;
                cj++;
            }
            if(ci==w1[i].length()){
                i++;
                ci=0;
            }
            if(cj==w2[j].length()){
                j++;
                cj=0;
            }
        }
        return i==w1.length&&j==w2.length;
    }
}