/*

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

--

The test cases look for possible overflow with large array

//////////////////////

The XOR trick works in two passes with a read-only array.

This avoids the problem of possible integer overflows which the sum and sum of squares solution has.

Let the two numbers be x and y, one of which is the missing number and the other repeated.

XOR all the elements of the array, along with 1,2,...,N.

The result is w = x XOR y.

Now since x and y are distinct, w is non-zero.

Pick any non-zero bit of w. x and y differ in this bit. Say the position of the bit is k.

Now consider a split of the array (and the numbers 1,2,...,N) into two sets, based on whether the bit at position k is 0 or 1.

Now if we compute the XOR (separately) of the elements of the two sets, the result has to be x and y.

Since the criteria for splitting is just checking if a bit is set of not, we can compute the two XORs of the two sets by making another pass through the array and having two variables, each of which holds the XOR of the elements seen so far (and 1,2,...N), for each set. At the end, when we are done, those two variables will hold x and y.


*/



public class Solution {
	// CANNOT MODIFY THE LIST
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    ArrayList<Integer> ret = new ArrayList<>();
        int xor = 0, x = 0, y = 0;
        
        for(int i=0; i < a.size(); i++) {
            xor ^= a.get(i);
        }
        
        for(int i=1; i<=a.size(); i++) {
            xor ^= i;
        }

        int setBit = xor & ~(xor-1);
    
        for(int i=0; i<a.size(); i++) {
            if((a.get(i) & setBit) != 0) {
                x ^= a.get(i);
            } else {
                y ^= a.get(i);
            }
        }
    
        for(int i=1; i<=a.size(); i++) {
            if((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }


        for(int i=0; i<a.size(); i++) {
            if(a.get(i) == x) {
                ret.add(x);
                ret.add(y);
                return ret;
            }

            if(a.get(i) == y) {
                ret.add(y);
                ret.add(x);
                return ret;
            }
        }

        return ret;
	}
}
