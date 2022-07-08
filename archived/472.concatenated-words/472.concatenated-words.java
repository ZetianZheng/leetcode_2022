import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 *
 * https://leetcode.com/problems/concatenated-words/description/
 *
 * algorithms
 * Hard (43.10%)
 * Likes:    1942
 * Dislikes: 226
 * Total Accepted:    134.6K
 * Total Submissions: 310.8K
 * Testcase Example:  '["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]'
 *
 * Given an array of strings words (without duplicates), return all the
 * concatenated words in the given list of words.
 * 
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words =
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 10^4
 * 0 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * 0 <= sum(words[i].length) <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // wordsSet accelerate searching:
        Set<String> wordsSet  = new HashSet<>(Arrays.asList(words));
    
        List<String> result = new ArrayList<>();
        for (String word : words) {
            // remove this word itself to make sure it made by at least two words
            wordsSet.remove(word);
            if (dfs(word, wordsSet)) {
                result.add(word);
            }
            wordsSet.add(word);
        }

        return result;
    }

    private boolean dfs(String word, Set<String> wordsSet) {
        // bc:
        if (wordsSet.contains(word)) {
            return true;
        }

        // rp:
        for (int i = 1; i < word.length(); i++) {
            // get slice of word, to see if it is contain in wordsSet:
            // dfs(rest part) is true as well
            if (wordsSet.contains(word.substring(0, i)) && 
            dfs(word.substring(i), wordsSet)) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

