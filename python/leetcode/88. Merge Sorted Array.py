from typing import List


class Solution:

    # cpu O(n) and ram O(1)
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        ptr1 = m - 1
        ptr2 = n - 1
        ptr_end = len(nums1) - 1
        if n == 0:
            return
        while ptr_end >= 0:
            if nums1[ptr1] > nums2[ptr2]:
                if ptr1 < 0:
                    while ptr2 >= 0:
                        nums1[ptr_end] = nums2[ptr2]
                        ptr2 -= 1
                        ptr_end -= 1
                else:
                    nums1[ptr_end] = nums1[ptr1]
                    ptr1 -= 1
                    ptr_end -= 1
            else:
                if ptr2 < 0:
                    while ptr1 >= 0:
                        nums1[ptr_end] = nums1[ptr1]
                        ptr1 -= 1
                        ptr_end -= 1
                else:
                    nums1[ptr_end] = nums2[ptr2]
                    ptr2 -= 1
                    ptr_end -= 1

        print(nums1)


Solution().merge([1], 1, [], 0)
Solution().merge([0, 0, 0, 0, 0], 0, [1, 2, 3, 4, 5], 5)
Solution().merge(nums1=[1, 2, 3, 0, 0, 0], m=3, nums2=[2, 5, 6], n=3)
