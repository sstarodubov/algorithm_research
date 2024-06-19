from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        l1 = []
        l2 = []

        def dfs(n: TreeNode, l):
            if not n:
                return
            if not n.left and not n.right:
                l.append(n.val)
                return

            dfs(n.left, l)
            dfs(n.right, l)

        dfs(root1, l1)
        dfs(root2, l2)

        return l1 == l2
