/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       if (head == null || left == right) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    // Step1: move prev to node before m
    for (int i = 1; i < left; i++) {
        prev = prev.next;
    }

    // Step2: reverse sublist from m to n
    ListNode curr = prev.next;
    ListNode nextNode = null;
    ListNode reversePrev = null;

    for (int i = 0; i <= right - left; i++) {
        nextNode = curr.next;
        curr.next = reversePrev;
        reversePrev = curr;
        curr = nextNode;
    }

    // Step3: reconnect
    prev.next.next = curr;    
    prev.next = reversePrev;  

    return dummy.next;
    }
}