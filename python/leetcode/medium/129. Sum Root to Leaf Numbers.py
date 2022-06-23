from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(n, xs):
            r = xs * 10 + n.val
            if not n.left and not n.right:
                self.ans += r
                return

            if n.left:
                dfs(n.left, r)
            if n.right:
                dfs(n.right, r)

        dfs(root, 0)

        return self.ans


assert 1026 == Solution().sumNumbers(TreeNode.build_tree([4, 9, 0, 5, 1]))
