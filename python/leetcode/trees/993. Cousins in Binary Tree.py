from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        def parent_depth(n: TreeNode, g: int, d=0, p=None):
            if not n:
                return None

            if n.val == g:
                return d, p
            a = parent_depth(n.left, g, d + 1, n)
            b = parent_depth(n.right, g, d + 1, n)
            if a: return a
            if b: return b
            return None

        xd, xp = parent_depth(root, x)
        yd, yp = parent_depth(root, y)
        return xd == yd and xp != yp


assert Solution().isCousins(TreeNode.build_tree([1, 2, 3, None, 4, None, 5]), 4, 5)
