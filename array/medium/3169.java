/*
You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.

 
 */

public class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by their start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int totalMeetingDays = 0;
        int currentEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > currentEnd) {
                // Non-overlapping interval
                totalMeetingDays += (end - start + 1);
                currentEnd = end;
            } else if (end > currentEnd) {
                // Overlapping interval; extend the current end
                totalMeetingDays += (end - currentEnd);
                currentEnd = end;
            }
            // If the meeting is within the current interval, no need to add days
        }

        // Calculate free days
        int freeDays = days - totalMeetingDays;
        return freeDays;
    }
}
