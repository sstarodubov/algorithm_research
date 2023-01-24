from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        self.ans = True
        self.p = None

        def dfs(n: TreeNode):
            if not self.ans:
                return
            if not n:
                return

            dfs(n.left)
            if self.p is None:
                self.p = n
            else:
                if self.p.val != n.val:
                    self.ans = False
                    return
                self.p = n
            dfs(n.right)

        dfs(root)
        return self.ans
