package Array;

import java.util.*;

public class MergedIntervals {

    public int[][] merge(int[][] intervals) {

        // Step 1: Sort all the intervals based on their starting times
        // This helps us to easily detect overlapping intervals as we go from left to
        // right.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // This will store our final list of merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 2: Loop through each interval one by one
        for (int[] current : intervals) {

            // If merged list is empty OR current interval does NOT overlap with the last
            // one
            // Overlap happens if current.start <= last.end
            // So here, if last.end < current.start → no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {

                // No overlap → just add the current interval to the result
                merged.add(current);

            } else {
                // Overlap detected → merge them
                // We merge by extending the end time of the last interval
                // new end = max(last.end, current.end)
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }

        // Step 3: Convert our list back into a 2D array to return
        return merged.toArray(new int[merged.size()][]);
    }
}
