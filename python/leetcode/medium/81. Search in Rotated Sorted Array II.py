from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if len(nums) == 1: return nums[0] == target

        def find_pivot():
            if nums[0] < nums[-1]: return 0

            l, r = 0, len(nums) - 1

            while l <= r:
                m = l + (r - l) // 2

                if nums[m] > nums[m + 1]:
                    return m + 1

                if nums[m] > nums[-1]:
                    l = m + 1

                else:
                    r = m
            return -1

        def bs(l, r):

            while l <= r:

                m = l + (r - l) // 2

                if nums[m] == target:
                    return True

                if nums[m] < target:
                    l = m + 1
                else:
                    r = m - 1

            return False


        pidx = find_pivot()

        if pidx == 0:
            return bs(0, len(nums) - 1)

        x = bs(0, pidx - 1)
        y = bs(pidx, len(nums) - 1)

        if x: return True
        if y: return True
        return False


assert not Solution().search(nums=[2, 5, 6, 0, 0, 1, 2], target=3)
assert Solution().search([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1], 2);
assert Solution().search(nums=[2, 5, 6, 0, 0, 1, 2], target=0)
