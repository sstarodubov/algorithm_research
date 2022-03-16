from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.ans = 0
        def dfs(node:TreeNode):
            if not node:
                return

            if low <= node.val <= high:
                self.ans += node.val
            dfs(node.left)
            dfs(node.right)
        dfs(root)

        return self.ans


assert 32 == Solution().rangeSumBST(root=TreeNode.build_tree([10, 5, 15, 3, 7, None, 18]), low=7, high=15)
