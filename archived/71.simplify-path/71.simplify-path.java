/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (38.85%)
 * Likes:    2436
 * Dislikes: 488
 * Total Accepted:    430.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"/home/"'
 *
 * Given a string path, which is an absolute path (starting with a slash '/')
 * to a file or directory in a Unix-style file system, convert it to the
 * simplified canonical path.
 * 
 * In a Unix-style file system, a period '.' refers to the current directory, a
 * double period '..' refers to the directory up a level, and any multiple
 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
 * problem, any other format of periods such as '...' are treated as
 * file/directory names.
 * 
 * The canonical path should have the following format:
 * 
 * 
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory
 * to the target file or directory (i.e., no period '.' or double period
 * '..')
 * 
 * 
 * Return the simplified canonical path.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory
 * name.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the
 * root level is the highest level you can go.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are
 * replaced by a single one.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

/**
 * use stack,
 * 复原路径
 * 什么时候用栈？满足后进先出，放进去的元素不会立即消费。有一个触发点，它触发之后，将栈顶元素pop出来进行某些操作。
 * 怎么一定做出这类题：找触发点。
 */
class SolutionSimplifyPath {
    public static String simplifyPath(String path) {
        // split the path by "/"
        String[] paths = path.split("/");
        // use stack
        Stack<String> stack = new Stack<>();
        for (String p : paths) {
            // when p equal is empty(avoid multiple splash: "///")
            // or p equal to ".", continue to next part
            if (p.equals(".") || p.isEmpty()){
                continue;
            } 
            // double "..", pop stack
            if (p.equals("..")) {
                if (!stack.empty())
                    stack.pop();
                continue;
            }

            stack.add(p);
        }
        String ans = "";

        while(!stack.isEmpty()) {
            ans = "/"  + stack.pop() + ans;
        }

        return ans.isEmpty() ? "/" : ans;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/hello///path"));

    }
}
// @lc code=end

