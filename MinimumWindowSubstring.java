class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> wordDict = constructWordDict(t);
        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            Integer count = wordDict.get(c);
            if (count == null) {
                continue;
            }
            wordDict.put(c, count - 1);
            // match another character
            if (count == 1) {
                // 1 to 0
                matchCount++;
            }
            while(matchCount == wordDict.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
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