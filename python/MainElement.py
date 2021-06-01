from typing import List


class Solution:

    # Time O(n) and Space O(n)
    def majorityElement(self, nums: List[int]) -> List[int]:
        d = {}
        t = {}
        for n in nums:
            if n not in d:
                d[n] = 1
            else:
                d[n] += 1
            if d[n] > (len(nums) / 3):
                t[n] = True

        return [num for num in t.keys()]


s = Solution()

assert [3] == s.majorityElement([3, 2, 3, 3, 3, 3]), "2"
assert [1, 2] == s.majorityElement([1, 2]), "1"
assert [3] == s.majorityElement([3]), "3"

print("tests passed")
