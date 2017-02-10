/**

Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist as per Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

///////////////////////////

I would use the Sieve of Eratosthenes to generate the prime numbers up to the input number.  Then I would iterate over the numbers and see if [current number] and [[input number] - [current number]] are both prime numbers.  If they are both prime numbers, append them to your answer list.

Algorithmic Complexity:
The Sieve of Eratosthenes algorithm (as implemented below) takes O(n)O(n) bits of space and runs in O(nloglogn))O(nlog⁡log⁡n)) operations.  The loop that runs after computing the Sieve takes O(1)O(1) space and runs in O(n)O(n) operations.  Thus, the overall complexity is:

Space: O(n)O(n)
Time: O(nloglogn)O(nlog⁡log⁡n)

However, there are more optimal implementations of the Sieve of Eratosthenes which use segmentation and wheel factorization.

One such implementation takes O(n1/2loglogn/logn)O(n1/2log⁡log⁡n/log⁡n) bits of space and runs in O(n)O(n) operations.

The Sieve of Atkin computes primes in O(n/loglogn)O(n/log⁡log⁡n) operations with only O(n1/2+o(1))O(n1/2+o(1)) bits of space.  However, most implementations of the Sieve of Atkin are slower than the Sieve of Eratosthenes in practice.

*/


public class Solution {
    public ArrayList<Integer> primesum(int a) {
        ArrayList<ArrayList<Integer>> summands = new ArrayList<ArrayList<Integer>>();
        boolean[] sieve = primeSieve(a);
        int i = 2;
        for(i = 2; i <= a / 2; i++){
            if(!sieve[i]) continue;
            int j = a - i;
            if(sieve[j]){
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(j);
                summands.add(pair);
            }
        }
        return summands.get(0);
    }
    
    public boolean[] primeSieve(int num) {
        boolean[] primes = new boolean[num];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        int i = 0;
        int j = 0;
        for(i = 2; i < num; i++){
            if(!primes[i]){
                continue;
            }
            int product = 1;
            for(j = 2, product = i * j; product < num; j++, product = i * j){
                primes[product] = false;
            }
        }
        return primes;
    }
}
