class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();

        Generate(n , "" , 0 , 0 , ans );
        return ans;

    }

    public void Generate(int n , String str ,int open , int close ,List<String> ans  ){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }
       
        if(open<n){
            Generate(n , str+"(", open+1 , close , ans);
        }

        if(close<open){
            Generate(n , str+")", open , close+1 , ans);
        }


    }
}