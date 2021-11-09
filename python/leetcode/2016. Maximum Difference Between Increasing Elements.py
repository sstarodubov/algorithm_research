from typing import List


class Solution:
    # O(n)
    def maximumDifference(self, nums: List[int]) -> int:
        lptr, rptr = 0, 1
        ans = -1
        while rptr < len(nums):
            if nums[lptr] >= nums[rptr]:
                lptr = rptr
            ans = max(ans, nums[rptr] - nums[lptr])
            rptr += 1

        return ans if ans > 0 else -1


assert Solution().maximumDifference([87, 68, 91, 86, 58, 63, 43, 98, 6, 40]) == 55
assert Solution().maximumDifference([9, 4, 3, 2]) == -1
assert Solution().maximumDifference([7, 1, 5, 4]) == 4
assert Solution().maximumDifference([1, 5, 2, 10]) == 9

print("tests passed")
