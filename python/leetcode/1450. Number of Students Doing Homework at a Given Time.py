from typing import List

class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        L, ans = len(startTime), 0
        for i in range(L):
            if queryTime >= startTime[i] and queryTime <= endTime[i]:
                ans += 1

        return ans


assert 1 == Solution().busyStudent(startTime=[1, 2, 3], endTime=[3, 2, 7], queryTime=4)
