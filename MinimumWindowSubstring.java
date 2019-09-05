class MinimumWindowSubstring {
    // https://www.youtube.com/watch?v=9qFR2WQGqkU&t=1s
    // time O(m) m is length of s + t
    // space O(n) n is length of t
    public String minWindow(String s, String t) {
        // edge case: s is shorter than t, then there's no valid substring
        if (s.length() < t.length()) {
            return "";
        }
        // use a hashmap to store a character, integer pair, where
        // key is the charater in t
        // value is the count of key in the String t
        Map<Character, Integer> wordDict = constructWordDict(t);
        
        // use slow, fast sliding window two pointers to solve this problem
        // why sliding window? the slow pointer would always go right
        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            Integer count = wordDict.get(c);
            // if the current charater c is not a character in t, we don't care about this character
            if (count == null) {
                continue;
            }
            // otherwise, it means the match time of the c should reduce 1
            wordDict.put(c, count - 1);
            // if count change from 1 to 0, it means the number of matchCount go up by 1
            if (count == 1) {
                // 1 to 0
                matchCount++;
            }
            // this means the current substring is a valid substring,
            // we can move the slow pointer in direction right to shorten the valid answer
            while(matchCount == wordDict.size()) {
                // update the minLen and the starting index of minLen substring if valid
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                // start move slow pointer
                // get the charater the slow pointer points to, if it isn't a character in t
                // if it isn't a character in t, we continue to next move
                // if it is a character in t, we update wordDict and the matchCount remaining
                // when moved to a place where the substring is not valid anymore, jump out of 
                // while loop and move the fast pointer
                char leftmost = s.charAt(slow++);
                Integer leftmostCount = wordDict.get(leftmost);
                if (leftmostCount == null) {
                    continue;
                }
                wordDict.put(leftmost, leftmostCount + 1);
                if (leftmostCount == 0) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }

    private Map<Character, Integer> constructWordDict(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }            
        }
        return map;
    }
}