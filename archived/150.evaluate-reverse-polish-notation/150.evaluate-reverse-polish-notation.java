/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (42.67%)
 * Likes:    3096
 * Dislikes: 635
 * Total Accepted:    418.9K
 * Total Submissions: 978.9K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, and /. Each operand may be an integer or
 * another expression.
 * 
 * Note that division between two integers should truncate toward zero.
 * 
 * It is guaranteed that the given RPN expression is always valid. That means
 * the expression would always evaluate to a result, and there will not be any
 * division by zero operation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 * 
 * 
 */

import java.util.Stack;

/**
 * stack to calculate tokens:
 */
// @lc code=start
class SolutionEvalRPN {
    public int evalRPN(String[] tokens) {
        // use stack to record numbers
        Stack<Integer> numberStack = new Stack<>();

        for (String token : tokens) {
            // if this token is an arithmetic token, pop out two number, to calculate
            if ("+-*/".contains(token)) {
                int a = numberStack.pop();
                int b = numberStack.pop();
                switch(token) {
                    case("+") :
                        numberStack.push(a + b);
                        break;
                    case("-") :
                        numberStack.push(b - a);
                        break;
                    case("*") :
                        numberStack.push(a * b);
                        break;
                    case("/") :
                        numberStack.push(b / a);
                }

            } else {
                // put digit into stack:
                numberStack.push(Integer.valueOf(token));
            }
        }
        return numberStack.pop();
    }
}
// @lc code=end

