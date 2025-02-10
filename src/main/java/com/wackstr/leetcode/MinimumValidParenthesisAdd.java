package com.wackstr.leetcode;

public class MinimumValidParenthesisAdd {

    /*
    Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3

Input: s = "()))(("
output: 4


Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
     */
    public int minAddToMakeValid(String s) {
        int opens = 0;
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                opens++;
                score++;
            }else if (s.charAt(i) == ')'){
                if(opens > 0){
                    opens--;
                    score--;
                }else{
                    score++;
                }
            }
        }
        return Math.abs(score);
    }

    public static void main(String[] args) {
        String input = "(((";
        MinimumValidParenthesisAdd solution = new MinimumValidParenthesisAdd();
        System.out.println(solution.minAddToMakeValid(input));
    }
}
