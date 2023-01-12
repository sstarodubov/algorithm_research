from typing import Optional, List

from leetcode.tree_node import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def fn(xs, s, e) -> Optional[TreeNode]:
            if s == e:
                return TreeNode(xs[e])
            if s > e or s < 0 or e >= len(nums):
                return None

            m = int((s + e) / 2)

            nw = TreeNode(nums[m])
            nw.left = fn(xs, s, m - 1)
            nw.right = fn(xs, m + 1, e)
            return nw

        return fn(nums, 0, len(nums) - 1)


ans = Solution().sortedArrayToBST([-10,-3,0,5,9])
print(ans)
