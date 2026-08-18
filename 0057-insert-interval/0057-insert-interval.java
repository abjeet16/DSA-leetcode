class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // result grows as we go — final size isn't known upfront
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: copy all intervals that end BEFORE newInterval starts.
        // These don't overlap, so append them untouched.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: absorb all intervals that overlap newInterval.
        // An overlap exists when the current interval's start <= newInterval's end.
        // For each overlap, expand newInterval to cover both.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the (possibly expanded) newInterval once all overlaps are absorbed.
        result.add(newInterval);

        // Phase 3: copy the remaining intervals — they all start AFTER newInterval ends.
        // These don't overlap either, so append them untouched.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][] — the empty template tells Java the type.
        return result.toArray(new int[0][]);
    }
}