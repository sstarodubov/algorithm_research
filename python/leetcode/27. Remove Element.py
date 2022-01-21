from typing import List


class Solution:

    # space O(1), time O(L)
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        L = len(nums)
        if L == 1:
            if nums[0] == val:
                nums.clear()
                return 0
            return 1

        ptr = L
        for i in range(L):
            if i >= ptr:
                break
            if nums[i] == val:

                while ptr == L or nums[ptr] == val:
                    ptr -= 1
                    if ptr <= i:
                        break
                nums[i], nums[ptr] = nums[ptr], nums[i]
        return ptr


assert 1 == Solution().removeElement([4, 5], 5)
assert 2 == Solution().removeElement([3, 3], 5)
assert 5 == Solution().removeElement(nums=[0, 1, 2, 2, 3, 0, 4, 2], val=2)
assert 2 == Solution().removeElement(nums=[3, 2, 2, 3], val=3)
