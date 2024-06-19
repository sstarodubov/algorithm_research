from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        self.ans = float("inf")

        def dfs(n: TreeNode):
            if not n:
                return

            if not n.left and not n.right:
                return

            if n.left.val == root.val:
                if n.right.val != root.val:
                    self.ans = min(self.ans, n.right.val)
                dfs(n.left)
            if n.right.val == root.val:
                if n.left.val != root.val:
                    self.ans = min(self.ans, n.left.val)
                dfs(n.right)

        dfs(root)
        if self.ans == float("inf"):
            return -1

        return self.ans


print(Solution().findSecondMinimumValue(
    TreeNode.build_tree([1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1])))
