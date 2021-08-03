from typing import List

"""
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.
"""


class Solution:

    # CPU O(n log n) and RAM O(n)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        nums.sort()
        ans_list = []
        prev = 1
        while prev != nums[0]:
            ans_list.append(prev)
            prev += 1
        for i in range(1, len(nums)):
            cur = nums[i]
            if cur == prev:
                continue
            elif cur - 1 != prev:
                while cur - 1 != prev:
                    prev += 1
                    ans_list.append(prev)
                prev = cur
            else:
                prev = cur
        last = nums[len(nums) - 1]
        while last != len(nums):
            last += 1
            ans_list.append(last)

        return ans_list


s = Solution()

assert [1, 2, 8] == s.findDisappearedNumbers([5, 4, 6, 7, 9, 3, 10, 9, 5, 6]), "10"
assert [1] == s.findDisappearedNumbers([2, 2]), "5"
assert [6, 8] == s.findDisappearedNumbers([10, 2, 5, 10, 9, 1, 1, 4, 3, 7]), "3"
assert [5, 6] == s.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]), "1"
assert [2] == s.findDisappearedNumbers([1, 1]), "2"

print("tests passed")
