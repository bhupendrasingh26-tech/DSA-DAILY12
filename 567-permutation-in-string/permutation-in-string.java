class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int m = s1.length();
       int n = s2.length();

       int[] freq = new int[26];
       for(char ch : s1.toCharArray()){
        freq[ch-'a']++;
       } 
       int [] window = new int[26];
       int l = 0;

       for(int r =0; r<n ; r++){
        window[s2.charAt(r)-'a']++;

        if(r-l+1>m){
             window[s2.charAt(l)-'a']--;
             l++;  
        }

        if(r-l+1==m && Arrays.equals(freq, window)){
            return true;
        }
       }

       return false;
    }
}