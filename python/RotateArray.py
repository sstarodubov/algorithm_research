from typing import List


class Solution:

    # Time O(n ^ 2) and Space O(1)
    def rotate(self, nums: List[int], k: int) -> None:
        if k == len(nums):
            return
        elif k > len(nums):
            k = k % len(nums)
        step = 0
        while step != k:
            self.shiftRight(nums)
            step += 1
        print(nums)

    def shiftRight(self, nums: List[int]) -> None:
        last = nums[len(nums) - 1]
        for i in range(len(nums) - 1, 0, -1):
            nums[i] = nums[i - 1]
        nums[0] = last


s = Solution()
s.rotate(nums=[1, 2, 3, 4, 5, 6, 7], k=3)
s.rotate(nums=[-1, -100, 3, 99], k=2)
