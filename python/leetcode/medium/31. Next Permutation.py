from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        for i in range(len(nums) - 2, -1, -1):
            p = i + 1
            if nums[i] < nums[p]:
                midx = p
                for j in range(p, len(nums)):
                    if nums[i] > nums[j]:
                        break
                    if nums[midx] > nums[j] > nums[i]:
                        midx = j
                nums[i], nums[midx] = nums[midx], nums[i]
                ys = nums[p:]
                ys.sort()
                for k in range(len(ys)):
                    nums[k + p] = ys[k]
                return
        nums.reverse()


Solution().nextPermutation([1, 5, 1])

xs = [1, 3, 2]
Solution().nextPermutation(xs)
assert xs == [2, 1, 3]

xs = [3, 2, 1]
Solution().nextPermutation(xs)
assert xs == [1, 2, 3]
