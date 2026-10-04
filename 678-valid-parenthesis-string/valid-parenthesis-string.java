class Solution {

    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()+1];

        return solve(s , 0 , 0 ,dp);
    }

    public Boolean solve(String s , int balance , int i ,Boolean [][] dp){
        if (balance<0){
            return false;
        }

        if(i==s.length()){
            return balance==0;
        }
        boolean ans;

        if(dp[i][balance]!=null){
            return dp[i][balance];
        }

        if(s.charAt(i)=='('){
           ans = solve(s , balance+1 , i+1 , dp);
        }else if(s.charAt(i)==')'){
            ans = solve(s , balance-1 , i+1 , dp);
        }else{
            boolean open = solve(s , balance+1, i+1 , dp);

            boolean close = solve(s , balance-1 , i+1 , dp);

            boolean none = solve(s , balance , i+1 , dp);

            ans = open || close || none ;
        }

        return dp[i][balance] =ans;
    }
}