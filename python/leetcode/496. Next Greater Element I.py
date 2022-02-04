from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = []

        for i in nums1:
            ptr = 0
            while nums2[ptr] != i:
                ptr += 1

            while ptr < len(nums2):
                if nums2[ptr] > i:
                    ans.append(nums2[ptr])
                    break
                ptr += 1
            if ptr == len(nums2):
                ans.append(-1)
        return ans


assert Solution().nextGreaterElement(nums1=[2, 4], nums2=[1, 2, 3, 4]) == [3, -1]
assert Solution().nextGreaterElement(nums1=[4, 1, 2], nums2=[1, 3, 4, 2]) == [-1, 3, -1]
