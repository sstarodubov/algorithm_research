from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        w, c = 0, 1
        for r in range(1, len(nums)):
            if nums[r - 1] == nums[r]:
                c += 1
            else:
                c = 1
            if c < 3:
                w += 1
            nums[w] = nums[r]
        return w + 1


assert 2 == Solution().removeDuplicates([1, 1])
assert 4 == Solution().removeDuplicates([1, 1, 1, 4, 4, 4])
assert 1 == Solution().removeDuplicates([1])
assert 2 == Solution().removeDuplicates([1, 2])
assert 5 == Solution().removeDuplicates([1, 1, 1, 2, 2, 3])
assert 7 == Solution().removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3])
