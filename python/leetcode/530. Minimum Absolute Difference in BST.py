from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.mn = float("inf")
        self.prev: TreeNode = None

        def dfs(node: TreeNode):
            if not node:
                return

            dfs(node.left)

            if self.prev:
                self.mn = min(self.mn, node.val - self.prev.val)

            self.prev = node

            dfs(node.right)

        dfs(root)

        return self.mn


assert 9 == Solution().getMinimumDifference(TreeNode.build_tree([236, 104, 701, None, 227, None, 911]))
