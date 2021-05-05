from typing import List


class Solution:
    # Time O(n ^3 )
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        count = 0
        for x in range(len(nums)):
            for y in range(len(nums)):
                arr = nums[x:y + 1]
                if (not arr): continue
                s = sum(arr)
                if lower <= s <= upper:
                    count += 1
        return count


s = Solution()

assert 3 == s.countRangeSum([-2, 5, -1], -2, 2), "3 =="
assert 1 == s.countRangeSum([0], 0, 0) , "1 =="

print("tests passed")
