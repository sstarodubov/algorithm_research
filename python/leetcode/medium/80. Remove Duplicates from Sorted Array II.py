from typing import List


class Solution:
    # time O(n + n), space O(1)
    def removeDuplicates(self, nums: List[int]) -> int:
        r, w = 0, 0
        count = 1
        while r < len(nums):
            if r > 0 and nums[r] == nums[r - 1]:
                count += 1
            else:
                count = 1

            if count > 2:

                while nums[r] == nums[r - 1]:
                    r += 1
                    if r >= len(nums):
                        return w
                count = 1

            nums[w] = nums[r]
            r += 1
            w += 1

        return w


assert 7 == Solution().removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3, 3])
assert 7 == Solution().removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3])
assert 5 == Solution().removeDuplicates([1, 1, 1, 2, 2, 3])
