/**
* * * * * * * * * * * * * * * * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * * * * * * * * * * * * * * * * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
//////
recursion with linked list may cause stack overflow for huge numbers


 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calculate(l1,l2,0);
        //return calculate(l1,l2); // alternate solution
    }
    public ListNode calculate(ListNode l1, ListNode l2, int carry){
        if(l1 == null & l2 == null && carry == 0) return null;
        if(l1 == null & l2 == null && carry != 0) return new ListNode(1);
        int sum = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
        ListNode result = new ListNode(sum%10); // getting last digit
        result.next = calculate((l1==null)?null:l1.next, (l2==null)?null:l2.next, sum/10); //if the sum is two digit number first digit is carry
        return result;
    }
    /* alternate solution */
    public ListNode calculate(ListNode a, ListNode b){
        ListNode c = new ListNode(0);
	    ListNode p1 = a;
	    ListNode p2 = b;
	    ListNode p3 = c;
	    int carry = 0;
	    while(p1!=null || p2!=null){
	        if(p1 != null){
	            carry += p1.val;
	            p1 = p1.next;
	        }
	        if(p2 != null){
	            carry += p2.val;
	            p2 = p2.next;
	        }
	        p3.next = new ListNode(carry%10);
	        p3 = p3.next;
	        carry /= 10;
	    }
	    if(carry == 1) {
	        p3.next = new ListNode(carry);
	    }
	    return c.next;
    }
    
}
