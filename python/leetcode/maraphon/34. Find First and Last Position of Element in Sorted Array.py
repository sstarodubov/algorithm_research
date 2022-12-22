from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        s = -1
        e = -1

        for i in range(len(nums)):
            if nums[i] == target and s == -1:
                s = i
                c = i
                while c < len(nums) and nums[c] == target:
                    e = c
                    c += 1
                break

        return [s, e]

assert Solution().searchRange(nums=[5, 7, 7, 8, 8, 10], target=8) == [3, 4]
assert Solution().searchRange(nums=[5, 7, 7, 8, 8, 10], target=6) == [-1, -1]
assert Solution().searchRange(nums=[], target=0) == [-1, -1]
