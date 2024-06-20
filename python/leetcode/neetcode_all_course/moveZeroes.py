from typing import List


class Solution:

    def moveZeroes(self, nums: List[int]) -> None:
        w = 0

        for r in range(len(nums)):
            if nums[r] == 0:
                continue
            else:
                nums[w] = nums[r]
                w += 1
        for i in range(w, len(nums)):
            nums[i] = 0


arr = [0, 1, 0, 3, 12]
Solution().moveZeroes(arr)
print(arr)




