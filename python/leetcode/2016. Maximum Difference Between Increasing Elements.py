from typing import List


class Solution:
    # O(n ^ 2)
    def maximumDifference(self, nums: List[int]) -> int:
        ans = -1
        for i in range(len(nums)):
            for y in range(i + 1, len(nums)):
                ans = max(ans, nums[y] - nums[i])
        return -1 if ans <= 0 else ans


assert Solution().maximumDifference([9, 4, 3, 2]) == -1
assert Solution().maximumDifference([7, 1, 5, 4]) == 4
assert Solution().maximumDifference([1, 5, 2, 10]) == 9

print("tests passed")
