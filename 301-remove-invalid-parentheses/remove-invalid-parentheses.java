class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } 
            else if (s.charAt(i) == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        int diff = left + right;

        remove(s, 0, diff, 0, "");

        return ans;
    }

    public void remove(String s, int i, int diff, int count, String curr) {

        if (count < 0) {
            return;
        }

        
        if (i == s.length()) {

            if (count == 0 && diff == 0) {

                if (!ans.contains(curr)) {
                    ans.add(curr);
                }
            }

            return;
        }

        char ch = s.charAt(i);

        
        if (ch == '(') {
            remove(s, i + 1, diff, count + 1, curr + ch);
        } 
        else if (ch == ')') {
            remove(s, i + 1, diff, count - 1, curr + ch);
        } 
        else {
            remove(s, i + 1, diff, count, curr + ch);
        }

        
        if (diff > 0 && (ch == '(' || ch == ')')) {
            remove(s, i + 1, diff - 1, count, curr);
        }
    }
}