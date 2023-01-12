from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(p: TreeNode, q: TreeNode) -> bool:
            if p is None and q is None:
                return True

            if p is None:
                return False
            if q is None:
                return False

            if p.val != q.val:
                return False

            return dfs(p.left, q.right) and dfs(p.right, q.left)

        return dfs(root.left, root.right)


assert Solution().isSymmetric(TreeNode.build_tree([1, 2, 2, 3, 4, 4, 3]))
