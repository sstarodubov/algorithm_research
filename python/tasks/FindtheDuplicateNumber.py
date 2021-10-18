from typing import List


class Solution:

    # cpu O(log(n) *n ) and ram O(1)
    # def findDuplicate(self, nums: List[int]) -> int:
    #     nums.sort()
    #     for i in range(1, len(nums)):
    #         if nums[i] == nums[i - 1]:
    #             return nums[i]

    # Floyd's Algorithms
    # cpu O(n) and ram O(1)
    def findDuplicate(self, nums: List[int]) -> int:
        # phase 1
        slow = nums[0]
        fast = nums[0]
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        # phase 2
        slow = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow


s = Solution()

assert s.findDuplicate([1, 3, 4, 2, 2]) == 2, 0
assert s.findDuplicate([3, 1, 3, 4, 2]) == 3, 1
assert s.findDuplicate([1, 1]) == 1, 2
assert s.findDuplicate([1, 1, 2]) == 1, 3

print("tests passed")
