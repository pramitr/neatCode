/*

Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

/////////

Max of 32 bit signed int should be 2^32
2^16 can have only one more power of 2 before that

*/



public class Solution {
    public boolean isPower(int a) {
        if(a == 1) return true;
        for(double x = 2; x<=Math.pow(2, 16); x++){
            for(double i = 2; i<33; i++){
                if(Math.pow(x, i) == a) return true;
                if(Math.pow(x, i) >= Math.pow(2,32)) break;
            }
        }
        return false;
    }
}
