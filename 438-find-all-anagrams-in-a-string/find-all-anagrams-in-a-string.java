class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m>n){
            return ans;
        }
      int[] freq = new int[26];

      for(char ch : p.toCharArray()){
        freq[ch-'a']++;
      }

      int[] window=  new int[26];
      int l =0;
      for(int r =0; r<s.length() ; r++){

        window[s.charAt(r)-'a']++;

        if(r-l+1>m){
            window[s.charAt(l)-'a']--;
            l++;
        }

        if(r-l+1==m && Arrays.equals(freq , window)){
            ans.add(l);
        }

      }

      return ans;

    }
}