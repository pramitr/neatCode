/**

Determine whether an integer is a palindrome. Do this without extra space.

*/


public class Solution {
    public boolean isPalindrome(int x) {
        int left,right,div;
        div = 1;
        if(x < 0) return false;
        //if(x < 10) return true;
        while(x/div >= 10){
            div *= 10;
        }
        
        while(x != 0 && div != 0){
            left = x / div;
            right = x % 10;
            
            if(left != right){
                
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
