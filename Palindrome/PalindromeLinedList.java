/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 0 <= Node.val <= 9
 * The number of nodes in the list is in the range [1, 10^5]
 */
class Solution {
  // turn list to array and compare
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    List<Integer> list = new ArrayList<>();
    while(head != null) {
      list.add(head.val);
      head = head.next;
    }
    int left = 0, right = list.size() - 1;
    while(left < right) {
      if (list.get(left) != list.get(right)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }

  // reverse second half and compare
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    // find mid node
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // reverse second half
    ListNode prev = slow;
    slow = slow.next;
    prev.next = null;
    while (prev != null) {
      ListNode tmp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = tmp;
    }

    // compare
    ListNode left = head, right = prev;
    while (right != null) {
      if (left.val != right.val)
        return false;

      left = left.next;
      right = right.next;
    }
    return true;
  }


}