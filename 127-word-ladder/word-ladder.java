class pair {
    String s;
    int val;

    pair(String s, int val) {
        this.s = s;
        this.val = val;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();

        for (String word : wordList) {
            set.add(word);
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<pair> q = new LinkedList<>();

        q.offer(new pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {

            pair node = q.poll();

            String word = node.s;
            int level = node.val;

         
            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;

                    String str = new String(arr);

                    if (set.contains(str)) {

                  
                        set.remove(str);

                        q.offer(new pair(str, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}