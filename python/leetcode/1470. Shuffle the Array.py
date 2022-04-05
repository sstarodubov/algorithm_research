from typing import List


class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        ans = [0] * (2 * n)
        rptr, lptr = n, 0
        for i in range(len(ans)):
            if i & 1 == 1:
                ans[i] = nums[rptr]
                rptr += 1
            else:
                ans[i] = nums[lptr]
                lptr += 1
        return ans


assert Solution().shuffle(nums=[2, 5, 1, 3, 4, 7], n=3) == [2, 3, 5, 4, 1, 7]
