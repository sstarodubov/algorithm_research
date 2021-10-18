from typing import List


class Solution:

    # Time O(n) and Space O(n)
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        a = [0] * n
        for i in range(n):
            a[(i + k) % n] = nums[i]

        nums[:] = a

s = Solution()
s.rotate(nums=[1, 2, 3, 4, 5, 6, 7], k=3)
s.rotate(nums=[-1, -100, 3, 99], k=2)
