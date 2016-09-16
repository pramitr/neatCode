/**
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
        int number = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
        ListNode result = new ListNode(number%10);
        result.next = calculate((l1==null)?null:l1.next, (l2==null)?null:l2.next, number/10);
        return result;
    }
}
