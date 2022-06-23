from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(n, xs):
            r = xs + str(n.val)
            if not n.left and not n.right:
                self.ans += int(r)
                return

            if n.left:
                dfs(n.left, r)
            if n.right:
                dfs(n.right, r)

        dfs(root, "")

        return self.ans


assert 1026 == Solution().sumNumbers(TreeNode.build_tree([4, 9, 0, 5, 1]))
