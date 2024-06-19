from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        self.ans = float("inf")
        self.prev = None

        def dfs(n: TreeNode):
            if not n:
                return

            dfs(n.left)
            if self.prev is None:
                self.prev = n.val
            else:
                self.ans = min(abs(n.val - self.prev), self.ans)
                self.prev = n.val
            dfs(n.right)

        dfs(root)

        return self.ans
