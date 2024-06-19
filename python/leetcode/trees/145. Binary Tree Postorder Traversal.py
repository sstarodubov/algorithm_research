from typing import List, Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        order = []

        def dfs(n:TreeNode):
            if not n:
                return
            dfs(n.left)
            dfs(n.right)
            order.append(n.val)

        dfs(root)

        return order