from typing import List


class Solution:
    # time O(n), space O(n)
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = {}
        stack = []
        for n in nums2:
            while stack and stack[-1] < n:
                m[stack[-1]] = n
                stack.pop()
            stack.append(n)

        ans = []
        for n in nums1:
            if n in m:
                ans.append(m[n])
            else:
                ans.append(-1)

        return ans


assert Solution().nextGreaterElement(nums1=[2, 4], nums2=[1, 2, 3, 4]) == [3, -1]
assert Solution().nextGreaterElement(nums1=[4, 1, 2], nums2=[1, 3, 4, 2]) == [-1, 3, -1]
