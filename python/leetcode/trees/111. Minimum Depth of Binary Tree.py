from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        if not root.left and not root.right:
            return 1
        lv: int = float("inf")
        rv: int = float("inf")
        if root.left:
            lv = self.minDepth(root.left) + 1
        if root.right:
            rv = self.minDepth(root.right) + 1
        return min(lv, rv)

assert 0 == Solution().minDepth(None)
assert 5 == Solution().minDepth(TreeNode.build_tree([2, None, 3, None, 4, None, 5, None, 6]))
assert 2 == Solution().minDepth(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
