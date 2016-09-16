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

 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calculate(l1,l2,0);
    }
    public ListNode calculate(ListNode l1, ListNode l2, int carry){
        if(l1 == null & l2 == null && carry == 0) return null;
        if(l1 == null & l2 == null && carry != 0) return new ListNode(1);
        int sum = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
        ListNode result = new ListNode(sum%10); // getting last digit
        result.next = calculate((l1==null)?null:l1.next, (l2==null)?null:l2.next, sum/10); //if the sum is two digit number first digit is carry
        return result;
    }
}
