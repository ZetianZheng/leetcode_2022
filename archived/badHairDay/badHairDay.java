import java.util.Stack;

public class badHairDay {
  /**
   * Some of Farmer John's N cows (1 ≤ N ≤ 800) are having a bad hair day! Since each cow is self-conscious about her messy hairstyle, FJ wants to count the number of other cows that can see the top of other cows' heads.
   * Each cow i has a specified height hi (1 ≤ hi ≤ 1,000) and is standing in a line of cows all facing east (to the right in our diagrams). Therefore, cow i can see the tops of the heads of cows in front of her (namely cows i+1, i+2, and so on), for as long as these cows are strictly shorter than cow i.
   * 一个牛可以看到前面的牛 说明有一个牛可以被身后的牛看到。
   * 所以如果一个牛被后面的牛挡了，再之后的牛都不会被它看到了，所以这个被挡的牛就可以剪枝掉。
   * 剪枝 -> 单调栈
   * @param cows
   * @return
   */
    static int seeCows(int[] cows) {
      
      if (cows.length == 0) {
          return 0;
      }

      // n -> cows number
      int n = cows.length;

      // result 
      int res = 0;

      // 使用单调递减栈进行剪枝：
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < n; i++) {
        if (stack.size() == 0 || stack.peek() > cows[i]) {
          stack.push(cows[i]);
        } else {
          while (stack.size() > 0 && stack.peek() < cows[i]) {
            stack.pop();
            // push掉 被挡住的cow，它被前面所有高于它的cow看过了。
            res += stack.size();
          }
          stack.push(cows[i]);
        }

      }

      // 剩下的是一个递减序列，每一个牛都被它之前的所有牛看到。
      while (stack.size() != 0) {
        stack.pop();
        res += stack.size();
      }

      return res;
    }
}
