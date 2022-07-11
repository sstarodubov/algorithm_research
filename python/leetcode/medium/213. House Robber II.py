from typing import List


class Solution:
    def helper(self, nums: List[int]) -> int:
        y, x = 0, 0
        for n in nums:
            r = max(y + n, x)
            y = x
            x = r

        return x

    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)

        ys = nums[1:]
        xs = nums[:-1]

        return max(self.helper(ys), self.helper(xs))


assert Solution().rob([200, 3, 140, 20, 10]) == 340
assert Solution().rob([1, 2, 3]) == 3
assert Solution().rob([1, 2, 1, 1]) == 3
assert Solution().rob([2, 3, 2]) == 3
