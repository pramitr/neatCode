/*

Because x is right shifted and y left shifted the result is that 
the original LSB of x eventually becomes the MSB of y

*/


public class Solution {
	public long reverse(long a) {
	    long b = 0;
        for (int i = 0; i < 32; ++i) {
            b <<= 1;       // make space
            b |= (a & 1);  // copy LSB of X into Y
            a >>>= 1;      // shift X right
        }
        return b;
	}
}

//// ALTERNATE WAY


long reverse(long x)
{
    x = (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    x = (((x & 0xcccccccc) >>> 2) | ((x & 0x33333333) << 2));
    x = (((x & 0xf0f0f0f0) >>> 4) | ((x & 0x0f0f0f0f) << 4));
    x = (((x & 0xff00ff00) >>> 8) | ((x & 0x00ff00ff) << 8));
    return ((x >>> 16) | (x << 16));
}
