from typing import List


class Solution:

    # cpu O(n log n) and ram O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 1:
            return intervals
        intervals.sort(key=lambda interval: interval[0])
        result = [intervals[0]]
        for i in range(1, len(intervals)):
            last = result[len(result) - 1]
            cur = intervals[i]
            if last[1] < cur[0]:
                result.append(cur)
            else:
                if last[1] <= cur[1]:
                    result.pop()
                    result.append([last[0], cur[1]])
        return result


assert Solution().merge([[1, 4], [2, 3]]) == [[1, 4]]
assert Solution().merge(intervals=[[1, 3], [2, 6], [8, 10], [15, 18]]) == [[1, 6], [8, 10], [15, 18]]
assert Solution().merge(intervals=[[1, 4], [4, 5]]) == [[1, 5]]
print("tests passed")
