/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, 
Given s = "Hello World",
return 5
*/


public class Solution {
    public int lengthOfLastWord(String s) {
        int i,l;
        l = s.length();
        i = 0;
        ArrayList<Character> lastWord = new ArrayList<Character>();
        boolean word = false;
        while(i<l){
            if(s.charAt(i) == ' '){
                word = true;
            }
            else {
                if(word == true){ // found word before
                    lastWord = new ArrayList<Character>();
                    word = false;
                }
                lastWord.add(s.charAt(i));
            }
            i++;
        }
        return lastWord.size();
    }
}
