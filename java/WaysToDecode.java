/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

Example :
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.

////////

It only makes sense to look at 1 digit or 2 digit pairs ( as 3 digit sequence will be greater than 26 ).

So, when looking at the start of the string, we can either form a one digit code, and then look at the ways of forming the rest of the string of length L - 1, or we can form 2 digit code if its valid and add up the ways of decoding rest of the string of length L - 2.
This obviously is exponential.

The code would go something like the following :

 int ways(string &s, int startIndex) {
    // BASE CASES

    int answer = 0;
if (isValid(s[startIndex])) answer += ways(s, startIndex + 1);
    if (isValid(s[startIndex] + s[startIndex + 1])) answer += ways(s, startIndex + 2);
    return answer;
 }



Time: O(n)
Space: O(n)


*/




public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int lastIndex = s.length() - 1;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(lastIndex,dp,s);
    }
    
    public int rec (int index, int[] dp, String s) {
        if (index < 0)
	        return 1;
	        
	    if (dp[index] != -1)
	        return dp[index];
	    
	    int ways = 0;
	    
	    if (s.charAt(index) > '0') {
        	ways = rec(index - 1, dp, s);
	    }
    	    
	    if (isValidTwoDigits(index, s)) {
	        ways += rec(index - 2, dp, s);
	    }
	    
	    return dp[index] = ways;
    }
    
    private boolean isValidTwoDigits(int i, String s) {
	    if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))){
	        return true;
	    }
	    return false;
	}
}
