/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * 区间不占用：
 * 1. start 排序
 * 2. 每个start于当前最小的end进行比较，如果>=,则不用新房间，反之则要新房。
 * 所以我们需要两样DS
 * 1. 排序
 * 2. minheap记录最小
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 1. sort the intervals by the start time, ascending
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        // 2. min-heap the ending time as the key, compare the next start time and smallest end time, decide whether we need more room
        Queue<Integer> pq = new PriorityQueue<Integer>(intervals.length, (Integer a, Integer b) -> a - b);
        
        // add the first meeting ending time:
        pq.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();          
            } 
            
            pq.add(intervals[i][1]);
        }
        
        return pq.size();
    }
}