from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        L = len(nums)
        K = k % L

        def idx(cur_idx: int) -> int:
            return (cur_idx + K) % L

        arr = [0] * L
        for i in range(L):
            arr[idx(i)] = nums[i]

        for i in range(L):
            nums[i] = arr[i]


nums = [1, 2, 3, 4, 5, 6, 7]
Solution().rotate(nums=nums, k=8)

print(nums)
