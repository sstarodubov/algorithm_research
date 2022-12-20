from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        ans = []
        intervals.sort(key=lambda x: x[0])
        for cs, ce in intervals:
            if not ans:
                ans.append([cs, ce])
                continue
            s, e = ans[-1]
            if cs <= e <= ce:
                ans.pop()
                ans.append([s, ce])
            elif s <= cs and ce <= e:
                continue
            else:
                ans.append([cs, ce])
        return ans


print(Solution().merge([[1, 4], [2, 3]]))
print(Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
print(Solution().merge([[1, 4], [4, 5]]))
