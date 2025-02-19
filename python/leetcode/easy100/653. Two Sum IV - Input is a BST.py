from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        self.result = False
        def dfs(root, s):
            if not root:
                return
            t = k - root.val
            if t in s:
                self.result = True
                return
            s.add(root.val)
            dfs(root.left, s)
            dfs(root.right,s)

        dfs(root, set())

        return self.result