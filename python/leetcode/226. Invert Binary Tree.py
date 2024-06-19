from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def invertTree(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        if not node:
            return node

        self.invertTree(node.left)
        self.invertTree(node.right)

        node.left, node.right = node.right, node.left

        return node

