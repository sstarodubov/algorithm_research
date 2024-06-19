from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.ans = 0

        def dfs(n: TreeNode):
            if not n:
                return

            if n.val > low:
                dfs(n.left)
            if low <= n.val <= high:
                self.ans += n.val
            if n.val < high:
                dfs(n.right)

        dfs(root)
        return self.ans
