from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lt, rt = 0, len(nums) - 1
        while lt < rt:
            m = (lt + rt) // 2
            if nums[m] == target:
                return m
            if target < nums[m]:
                rt = m - 1
            else:
                lt = m + 1
        if nums[lt] != target:
            return -1
        return lt


assert Solution().search(nums=[-1, 0, 3, 5, 9, 12], target=2) == -1
assert Solution().search(nums=[-1, 0, 3, 5, 9, 12], target=9) == 4
