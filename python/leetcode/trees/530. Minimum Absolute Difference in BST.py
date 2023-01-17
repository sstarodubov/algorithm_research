from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.p = None
        self.ans = float("inf")

        def dfs(n: TreeNode):
            if not n:
                return

            dfs(n.left)
            if self.p is not None:
                self.ans = min(self.ans, n.val - self.p.val)
            self.p = n
            dfs(n.right)

        dfs(root)
        if self.p is None:
            return root.val
        return self.ans


assert 1 == Solution().getMinimumDifference(TreeNode.build_tree([4, 2, 6, 1, 3]))
