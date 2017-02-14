/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1

*/


public class Solution {
	public int colorful(int a) {
	    if (a<10) return 1;
	    String numString = String.valueOf(a);
	    int len = numString.length();
	    int i = 0;
	    int j = 0;
	    List<Integer> map = new ArrayList<Integer>();
	    for(i=1;i<=len;i++){
	        for(j=0;j+i<=len;j++){
	            int digits = Integer.parseInt(numString.substring(j,j+i));
	            int product = getProduct(digits);
	            if(map.contains(product)){
	                return 0;
	            }
	            else {
	                map.add(product);
	            }
	        }
	    }
	    return 1;
	}
	
	public int getProduct(int digits) {
	    if(digits < 10) return digits;
	    int num = digits;
	    int product = 1;
	    while(num > 0) {
	        product = product * (num % 10);
	        num = num / 10;
	    }
	    return product;
	}
}
