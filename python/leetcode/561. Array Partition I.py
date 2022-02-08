from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        ans = 0
        for i in range(1, len(nums), 2):
            t = min(nums[i], nums[i - 1])
            ans += t

        return ans


assert Solution().arrayPairSum([1,4,3,2]) == 4