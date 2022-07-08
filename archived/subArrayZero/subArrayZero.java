import java.util.*;

public class subArrayZero {
    /**
     * Given an array, find all subarrays in the array which has sum 0. The result you return should be sorted by the start first. If start are the same, then sort by end.
     * use hash map to record the sum that appear before:
     */
    static List<List<Integer>> findSubArrays(int[] nums) {
        Map<Integer, List<Integer>> sumInds = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(Arrays.asList(0, i));
            }

            if (sumInds.containsKey(sum)) {
                for (int v : sumInds.get(sum)) {
                    result.add(Arrays.asList(v + 1, i));
                }
            }

            List<Integer> newList = sumInds.getOrDefault(sum, new ArrayList<>());
            newList.add(i);
            sumInds.put(sum, newList);
        }

        result.sort((o1, o2) -> {
            if (Objects.equals(o1.get(0), o2.get(0))) {
                return o1.get(1) - o2.get(1);
            }
            return o1.get(0) - o2.get(0);
        });
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{6,3,-1,-3,4,-2,2,4,6,-12,-7};
        findSubArrays(test);
    }
}
