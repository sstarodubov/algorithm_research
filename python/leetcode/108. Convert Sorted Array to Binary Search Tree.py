from typing import Optional, List

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:

        if not nums:
            return None
        if len(nums) == 1:
            return TreeNode(nums[0])

        middle = len(nums) // 2

        new_node = TreeNode(nums[middle])
        new_node.left = self.sortedArrayToBST(nums[:middle])
        new_node.right = self.sortedArrayToBST(nums[middle + 1:])

        return new_node


node = Solution().sortedArrayToBST([-10, -3, 0, 5, 9])
