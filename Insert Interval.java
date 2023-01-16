class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length && intervals[idx][0] < newInterval[0]) {
            ans.add(intervals[idx++]);
        }
        if (ans.size() == 0 || newInterval[0] > ans.get(ans.size() - 1)[1]) {
            ans.add(newInterval);
        }
        else {
            int[] lastInterval = ans.get(ans.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }
        while (idx < intervals.length) {
            int[] lastInterval = ans.get(ans.size() - 1);
            if (lastInterval[1] >= intervals[idx][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx++][1]);
            }
            else ans.add(intervals[idx++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}