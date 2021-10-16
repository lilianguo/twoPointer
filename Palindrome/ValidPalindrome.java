/**
 *
 *
 *
 * 125. Valid Palindrome
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return true;
    }
    for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
      while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
    }
    return true;
  }
}