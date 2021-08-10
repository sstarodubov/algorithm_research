"""
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.

"""
from typing import List


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __str__(self):
        return f"({self.start},{self.end})"


class Solution:

    # cpu O(n log n) and ram O(1)
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if len(intervals) in (0, 1):
            return True
        intervals.sort(key=lambda x: x.start)

        for i in range(1, len(intervals)):
            prev_last = intervals[i - 1].end
            cur_first = intervals[i].start
            if prev_last >= cur_first:
                return False
        return True


s = Solution()

assert not s.canAttendMeetings([Interval(15, 20), Interval(5, 10), Interval(0, 30)]), 0
assert s.canAttendMeetings(intervals=[Interval(5, 8), Interval(9, 15)]), 1

print("tests passed")
