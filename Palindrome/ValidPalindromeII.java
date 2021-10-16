/**
 * 680. Valid Palindrome II
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 **/

class Solution {
  public boolean validPalindrome(String s) {
    if (s == null || s.length() < 3) {
      return true;
    }
    return helper(s, 0, s.length() - 1, 1);
  }

  private boolean helper(String s, int left, int right, int count) {
    if (count < 0 || left > right) {
      return false;
    }
    while(left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        count--;
        if (count < 0) {
          return false;
        } else {
          return helper(s, left, right - 1, count) ||
              helper(s, left + 1, right, count);
        }
      }
    }
    return true;
  }
}