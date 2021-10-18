from typing import List


class Solution:
    # cpu O(n) and Space O(n)
    def majorityElement(self, nums: List[int]) -> int:
        hm = {}
        for n in nums:
            if n in hm:
                count = hm[n] + 1
                if count >= len(nums) / 2:
                    return n
                else:
                    hm[n] = count
            else:
                hm[n] = 1
        return nums[0]


s = Solution()

assert s.majorityElement([3, 2, 3]) == 3, 1
assert s.majorityElement([2, 2, 1, 1, 1, 2, 2]) == 2, 2

print("tests passed")
