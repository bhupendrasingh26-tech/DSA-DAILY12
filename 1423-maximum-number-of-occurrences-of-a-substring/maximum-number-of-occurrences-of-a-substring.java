class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i + minSize <= s.length(); i++) {

            String sub = s.substring(i, i + minSize);

            if (unique(sub, maxLetters)) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }

        return map.isEmpty() ? 0 : Collections.max(map.values());
    }

    public boolean unique(String s, int maxLetters) {

        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        return set.size() <= maxLetters;
    }
}