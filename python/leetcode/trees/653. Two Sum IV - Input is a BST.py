from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        m = set()
        self.a = False

        def dfs(n: TreeNode):
            if not n:
                return

            dfs(n.left)
            if k - n.val in m:
                self.a = True
                return
            m.add(n.val)
            dfs(n.right)
        dfs(root)
        return self.a
