from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.backtrack(nums, 0, ans)
        return ans

    def backtrack(self, nums: List[int], idx: int, ans: List[int]):
        if idx >= len(nums):
            ans.append(nums[:])
        else:
            for i in range(idx, len(nums)):
                nums[idx], nums[i] = nums[i], nums[idx]
                self.backtrack(nums, idx + 1, ans)
                nums[i], nums[idx] = nums[idx], nums[i]


assert Solution().permute([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
print("tests passed")
