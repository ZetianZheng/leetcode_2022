import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RecursionOA1 {
    private static final int[] formPolygon2 = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
    private static final int[] formPolygon3 = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    private static final int[] formPolygon4 = new int[]{1,1,1,2};
    /**
     * Find subset of elements that are selected from a given set of positive integers whose sum adds up to a given number K.
     * @param nums
     * @param target
     * @return
     */
    static List<List<Integer>> subsetSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        subsetHelper(nums, 0, target, curr, result);
        return result;
    }
    
    private static void subsetHelper(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> result) {
      // base case:
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        if (target < 0 || index >= nums.length) {
            return; 
        }
        
        // recursion:
        curr.add(nums[index]);
        // take the nums[index]
        subsetHelper(nums, index + 1, target - nums[index], curr, result);
        curr.remove(curr.size() - 1);
        // do not take nums[index]
        subsetHelper(nums, index + 1, target, curr, result);
    }

    /**
     * You have several sticks whose lengths may not be identical,
     * what you need to do is to decide if those sticks can make one Equilateral triangle (Triangle with same length of all sides).
     * You have to use up all the sticks and cannot break any of them.
     *
     * You output will be true or false
     * @param sticks
     * @return
     */
    static boolean canFormTriangle(int[] sticks) {
        return triangleHelper(sticks, 0, 0, 0, 0);
    }
    private static boolean triangleHelper(int[] sticks, int index, int a, int b, int c) {
        if (index == sticks.length) {
            if (a == b && b == c) {
                return true;
            } else {
                return false;
            }
        }

        return triangleHelper(sticks, index + 1, a + sticks[index], b, c) ||
                triangleHelper(sticks, index + 1, a , b + sticks[index], c)||
                triangleHelper(sticks, index + 1, a, b, c + sticks[index]);
    }

    /**
     * You have several sticks whose lengths may not be identical,
     * what you need to do is to decide if those sticks can make one polygon with equal sides.
     * You have to use up all the sticks and cannot break any of them.
     *
     * You output will be a boolean variable: true or false
     * @param sticks
     * @param sidesNum
     * @return
     */
    static boolean formPolygon(int[] sticks, int sidesNum) {
        // corner case:
        if (sticks == null || sticks.length < sidesNum) {
            return false;
        }

        // get the sum of all sticks
        int sum = Arrays.stream(sticks).sum();

        // cannot average the sticks sum to each side.
        if (sum % sidesNum != 0) {
            return false;
        }
        // get the length of each side.
        int target = sum / sidesNum;

        int[] sides = new int[sidesNum];
        return polygonHelper(sticks, target,0, sides);
    }

    /**
     * recursion function
     * @param sticks sticks array
     * @param target length of polygon
     * @param index current sticks index
     * @param sides each length of polygon for current
     * @return
     */
    private static boolean polygonHelper(int[] sticks, int target, int index, int[] sides) {
        if (index == sticks.length) {
            return validPolygon(target, sides);
        }

        // flag: if any possibility return true, return true,  otherwise, return false
        boolean flag = false;

        // all action, try to put current sticks into each side.
        for (int i = 0; i < sides.length; i++) {
            // optimize: when sides after sum bigger than target, continue to next possibility
            if (sides[i] + sticks[index] > target) {
                continue;
            }

            // back tracking:
            sides[i] += sticks[index];
            flag = flag || polygonHelper(sticks, target,index + 1, sides);
            sides[i] -= sticks[index];
        }
        return flag;
    }

    private static boolean validPolygon(int target, int[] sides) {
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] != target){
                return false;
            }
        }

        return true;
    }

    /**
     * Lucky Numbers
     *
     * 888 is a lucky number. And for each American phone number, we can actually add some operators to make it become 888. For example:
     *
     * phone number is 7765332111, you will have
     *
     * 7/7*65*3+3*21*11 = 888
     *
     * 776+5+3*32+11*1 = 888
     *
     * We want to get a full list of all the operation equations that can get a certain lucky number
     *
     *
     * Additional information:
     *
     * we can have "0" but we cannot have "05", "032".
     *
     * If a number cannot be divided, you cannot use it. For example, 55/2 is not allowed, you need to make sure the division can always be an integer result.
     *
     * 0 cannot be divisor.
     * @param num
     * @param target
     * @return
     */
    static String[] luckyNumbers(String num, int target) {
        // return the String list actually is return the path, so we need backtracking:
        List<String> resultList = new ArrayList<>();
        luckyNumbersHelper(num, "", 0, 0, 0, target, resultList);
        String[] results = new String[resultList.size()];
        results = resultList.toArray(results);
        return results;
    }

    private static void luckyNumbersHelper(String num, String currStr, int index, long last, long current, int target, List<String> result) {
        // base case: reach the last number of num, put the lucky number into result.
        if (index == num.length()) {
            if (current == target) {
                result.add(currStr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i != index)
                break;
            // get number from index ~ i:
            String numStr = num.substring(index, i + 1);
            long number = Long.parseLong(numStr);

            // the first number:
            if (index == 0) {
                luckyNumbersHelper(num, currStr + numStr, i + 1, number, number, target, result);
            } else {
                // +:
                luckyNumbersHelper(num, currStr + "+" + numStr, i + 1, number, current + number, target, result);
                // -:
                luckyNumbersHelper(num, currStr + "-" + numStr, i + 1, -number, current - number, target, result);
                // *:
                luckyNumbersHelper(num, currStr + "*" + numStr, i + 1, last * number, current - last + last * number, target, result);

                // 被除数不为0，且可以整除：
                if (number != 0 && last % number == 0) {
                    luckyNumbersHelper(num, currStr + "/" + numStr, i + 1, last / number, current - last + last / number, target, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 1, 1};
        int[] nums1 = new int[]{1, 1, 1, 1, 1};
//        List<List<Integer>> re = subsetSums(nums, 7);
//        System.out.println(re);
//        String[] x = luckyNumbers("123456", 1);
//        System.out.println(Arrays.asList(x));
        System.out.println(formPolygon(formPolygon2, 100));
        System.out.println(formPolygon(formPolygon3, 100));
        System.out.println(formPolygon(formPolygon4, 4));
        System.out.println(formPolygon(new int[]{}, 3));
        System.out.println(formPolygon(new int[]{1, 3, 2, 3}, 3));
    }
}
// @lc code=end

