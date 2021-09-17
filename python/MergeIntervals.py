from typing import List

"""
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an 
array of the non-overlapping intervals that cover all the intervals in the input. 
"""


class Solution:

    # cpu O(n log n) and ram O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals.sort(key=lambda pair: pair[0])
        for i, interval in enumerate(intervals):
            if not result:
                result.append(interval)
            else:
                last = result[len(result) - 1]
                if last[0] <= interval[0] and last[1] >= interval[1]:
                    continue
                elif last[0] <= interval[0] <= last[1]:
                    last[1] = interval[1]
                else:
                    result.append(interval)
        return result


s = Solution()

assert s.merge([[1, 4], [2, 3]]) == [[1, 4]]
assert s.merge([[1, 3], [2, 6], [8, 10], [15, 18]]) == [[1, 6], [8, 10], [15, 18]]
assert s.merge([[1, 4], [4, 5]]) == [[1, 5]]
print("tests passed")
