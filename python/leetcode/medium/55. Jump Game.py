from typing import List


class Solution:

    #time O(n) , space O(1)
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <= 1:
            return True
        if nums[0] == 0:
            return False
        steps = nums[0]
        so_far = 1
        for i in range(1, len(nums)):
            if steps == 0:
                return False
            steps -= 1
            so_far += 1
            if nums[i] > steps:
                steps = nums[i]

        return so_far >= len(nums) - 1


assert not Solution().canJump([3, 2, 1, 0, 4])
assert Solution().canJump([1, 2, 3])
assert Solution().canJump([2, 3, 1, 1, 4])
assert Solution().canJump([2, 0])
assert not Solution().canJump([0, 1])
assert Solution().canJump([0])
