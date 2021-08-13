from typing import List

"""
Let's call an array arr a mountain if the following properties hold:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... arr[i-1] < arr[i]
        arr[i] > arr[i+1] > ... > arr[arr.length - 1]

Given an integer array arr that is guaranteed to be a mountain, return any i such that 
arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
"""


class Solution:

    # cpu O( log n ) and ram O(1)
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left = 0
        right = len(arr) - 1
        while left <= right:
            middle = (right + left) // 2
            if arr[middle - 1] < arr[middle] > arr[middle + 1]:
                return middle
            elif arr[middle - 1] < arr[middle] < arr[middle + 1]:
                left = middle
            elif arr[middle - 1] > arr[middle] > arr[middle + 1]:
                right = middle
        return -1


s = Solution()

assert 1 == s.peakIndexInMountainArray(arr=[0, 1, 0]), 0
assert 1 == s.peakIndexInMountainArray(arr=[0, 2, 1, 0]), 1

print("tests passed")
