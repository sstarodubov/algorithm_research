from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        nums.reverse()

        def rev(l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
        rev(0, k - 1)
        rev(k, len(nums) - 1)

nums = [1, 2, 3, 4, 5, 6, 7]
Solution().rotate(nums=nums, k=5)

print(nums)
