from typing import List


class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        nums.sort(reverse=True)

        s = sum(nums)
        ls, rs = 0, s
        i = 0
        while rs >= ls and i < len(nums):
            ls += nums[i]
            rs -= nums[i]
            i += 1

        return nums[:i]


print(Solution().minSubsequence([4, 3, 10, 9, 8]))
