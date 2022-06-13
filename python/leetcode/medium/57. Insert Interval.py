from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        def merge(intervals: List[List[int]]) -> List[List[int]]:

            ans = []
            for ps, pe in intervals:
                if not ans:
                    ans.append([ps, pe])
                else:
                    xs, xe = ans[-1]

                    if xs <= ps and xe <= pe and xe < ps:
                        ans.append([ps, pe])
                    elif xs <= ps and xe <= pe:
                        ans.pop()
                        ans.append([xs, pe])
                    elif xs <= ps and xe >= pe:
                        continue
                    else:
                        ans.append([ps, pe])
            return ans

        intervals.append(newInterval)
        intervals.sort(key=lambda arr: arr[0])

        return merge(intervals)


assert Solution().insert(intervals=[[1, 3], [6, 9]], newInterval=[2, 5]) == [[1, 5], [6, 9]]
assert Solution().insert(intervals=[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval=[4, 8]) == [[1, 2], [3, 10],
                                                                                                        [12, 16]]
