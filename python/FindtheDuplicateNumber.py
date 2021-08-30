from typing import List


class Solution:

    # cpu O(log(n) *n ) and ram O(1)
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                return nums[i]


s = Solution()

assert s.findDuplicate([1, 3, 4, 2, 2]) == 2, 0
assert s.findDuplicate([3, 1, 3, 4, 2]) == 3, 1
assert s.findDuplicate([1, 1]) == 1, 2
assert s.findDuplicate([1, 1, 2]) == 1, 3

print("tests passed")
