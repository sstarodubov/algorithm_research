from typing import List

"""
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 """


class Solution:

    # Time O(n) and Space O(1)
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) == 1: return nums[0]
        nums.sort(reverse=True)
        for i in range(len(nums)):
            if i + 1 == k:
                return nums[i]


s = Solution()

assert 5 == s.findKthLargest(nums=[3, 2, 1, 5, 6, 4], k=2), "1"
# assert 4 == s.findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], k=4), "2"

print("tests passed")
