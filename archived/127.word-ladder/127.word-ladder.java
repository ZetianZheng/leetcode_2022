import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Hard (35.51%)
 * Likes:    7996
 * Dislikes: 1649
 * Total Accepted:    774.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... ->
 * sk such that:
 * 
 * 
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
 * to be in wordList.
 * sk == endWord
 * 
 * 
 * Given two words, beginWord and endWord, and a dictionary wordList, return
 * the number of words in the shortest transformation sequence from beginWord
 * to endWord, or 0 if no such sequence exists.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
 * -> "dog" -> cog", which is 5 words long.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no
 * valid transformation sequence.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English
 * letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * get the shortest path, so we can choose to use BFS, 
     * try to change the each letter from A-Z, 
     * if this word contains in the list and not been visited, but it into bfs queue
     * record the height of bfs, which is the answer.
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // get all word into the hashset.
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> seen  = new HashSet<>();
        int result = 0;

        Queue<String> ladderQueue = new LinkedList<>();
        ladderQueue.add(beginWord);
        seen.add(beginWord);
        
        // bfs: 
        while (!ladderQueue.isEmpty()) {
            // record current level size:
            int size = ladderQueue.size();

            // add next level candidates string:
            for (int i = 0; i < size; i++) {
                // get current string
                String curr = ladderQueue.poll();
                // change one letter and compare with the hashset:
                for (int p = 0; p < curr.length(); p++) {
                    for (String s: changeOneLetterContainInList(wordSet, seen, curr, p)){
                        if (s.equals(endWord)) {
                            return result + 1;
                        }
                        ladderQueue.offer(s);
                    }
                }    
            }

            // level plus one:
            result += 1;
        }

        // how many words on the path:
        return 0;
    }

    /**
     * Change one letter of the word in position p, put this word into next bfs level if this word: 
     * not been visited, in the wordlist
     * @param wordSet all word list
     * @param seen hashset record all visited word
     * @param str word to change
     * @param p postition of word which need be changed
     * @return
     */
    private List<String> changeOneLetterContainInList(Set<String> wordSet, Set<String> seen, String str, int p) {
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char x = (char)('a' + i);
            String strChanged = str.substring(0, p) + x + str.substring(p + 1);
            if (!seen.contains(strChanged) && wordSet.contains(strChanged)) {
                wordsList.add(strChanged);
                seen.add(strChanged);
            }
        }

        return wordsList;
    }
}
// @lc code=end

