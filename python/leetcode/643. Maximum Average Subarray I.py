from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        lt, rt = 0, k - 1
        cs = 0
        for i in range(k):
            cs += nums[i]
        ans = cs / k

        while rt + 1 < len(nums):
            cs = (cs - nums[lt] + nums[rt + 1])
            lt += 1
            rt += 1
            ans = max(ans, cs / k)
        return ans


assert Solution().findMaxAverage([8, 0, 1, 7, 8, 6, 5, 5, 6, 7], 5) == 6.20000
assert Solution().findMaxAverage([7, 4, 5, 8, 8, 3, 9, 8, 7, 6], 7) == 7.00000
assert Solution().findMaxAverage(nums=[1, 12, -5, -6, 50, 3], k=4) == 12.75000
assert Solution().findMaxAverage(nums=[5], k=1) == 5.000
