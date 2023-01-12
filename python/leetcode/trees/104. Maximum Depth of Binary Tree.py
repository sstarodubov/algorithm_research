from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        d1 = self.maxDepth(root.left)
        d2 = self.maxDepth(root.right)

        return max(d1, d2) + 1



